package com.restaurantexplorer.Authentication;

import com.restaurantexplorer.security.JwtService;

import com.restaurantexplorer.user.Role;
import com.restaurantexplorer.user.User;
import com.restaurantexplorer.user.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AuthenticationService {

	private final UserRepository repository;

	private final PasswordEncoder passwordEncoder;

	private final JwtService jwtService;

	private final AuthenticationManager authenticationManager;

	public AuthenticationService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService,
			AuthenticationManager authenticationManager) {
		super();
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}

	public AuthenticationResponse register(RegisterRequest request) {// VALIDATION FOR UNIQUE?
		User user = new User(null, request.getUsername(), passwordEncoder.encode(request.getPassword()), Role.USER);
		User savedUser = addUser(user);
		String jwtToken = jwtService.generateToken(savedUser);

		return new AuthenticationResponse(jwtToken, request.getUsername());

	}

	public User addUser(User user) {// VALIDATION FOR UNIQUE?

		// VALIDATION FOR UNIQUE User name/email?
		User savedUser = repository.save(user);
		return savedUser;
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		User user = repository.findByUsername(request.getUsername()).orElseThrow();
		String jwtToken = jwtService.generateToken(user);

		return new AuthenticationResponse(jwtToken, request.getUsername());
	}

}
