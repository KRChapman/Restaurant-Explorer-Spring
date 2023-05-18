package com.restaurantexplorer.Authentication;

import com.restaurantexplorer.user.UserRepository;
import com.restaurantexplorer.security.JwtService;
import com.restaurantexplorer.user.Role;
import com.restaurantexplorer.user.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTest {
	@Mock
	private UserRepository userRepository;

	@Mock
	private PasswordEncoder passwordEncoder;

	@Mock
	private JwtService jwtService;

	@Mock
	private AuthenticationManager authenticationManager;

	private AuthenticationService underTest;

	private AutoCloseable autoClosable;

	@BeforeEach
	void setup() {
		autoClosable = MockitoAnnotations.openMocks(this);
		underTest = new AuthenticationService(userRepository, passwordEncoder, jwtService, authenticationManager);
	}

	@AfterEach
	void tearDown() throws Exception {
		autoClosable.close();
	}

	@Test
	void testSaveUserInRegister() {
		String username = "dan";
		RegisterRequest request = new RegisterRequest(username, "123");
		User user = new User(null, request.getUsername(), passwordEncoder.encode(request.getPassword()), Role.USER);

		AuthenticationResponse tester = underTest.register(request);

		assertEquals(username, tester.getUsername());

	}

	@Test
	void testaddUser() {

		RegisterRequest request = new RegisterRequest("dan", "123");
		User user = new User(null, request.getUsername(), passwordEncoder.encode(request.getPassword()), Role.USER);

		underTest.addUser(user);

		ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

		verify(userRepository).save(userArgumentCaptor.capture());

		User capUser = userArgumentCaptor.getValue();

		assertThat(capUser).isEqualTo(user);
	}
}
