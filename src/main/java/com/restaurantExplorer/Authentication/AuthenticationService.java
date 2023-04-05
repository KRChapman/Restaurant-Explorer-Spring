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

  public AuthenticationService(UserRepository repository, 
			PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
		super();
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}

  public AuthenticationResponse register(RegisterRequest request) {//VALIDATION FOR UNIQUE?
  var user = new User(null,  request.getUsername()
		  ,passwordEncoder.encode(request.getPassword()),Role.USER);
    		
    var savedUser = repository.save(user);
    var jwtToken = jwtService.generateToken(user);

    return new AuthenticationResponse(jwtToken, request.getUsername());

  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getUsername(),
            request.getPassword()
        )
    );
    var user = repository.findByUsername(request.getUsername())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);

    return new AuthenticationResponse(jwtToken,  request.getUsername());
  }

}
