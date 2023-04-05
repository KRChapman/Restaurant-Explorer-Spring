package com.restaurantexplorer.Authentication;





public class AuthenticationResponse {

	  private String token;
	  private String username;
	
	public AuthenticationResponse() {
		super();
	}
	public AuthenticationResponse(String token, String username) {
		super();
		this.token = token;
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public String getUsername() {
		return username;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	public void setUsername(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "AuthenticationResponse [token=" + token + "]";
	}
  
}
