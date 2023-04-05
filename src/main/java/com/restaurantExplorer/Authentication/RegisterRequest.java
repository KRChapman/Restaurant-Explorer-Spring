package com.restaurantexplorer.Authentication;




public class RegisterRequest {


  private String username;
  private String password;
public RegisterRequest( String username, String password) {
	super();

	this.username = username;
	this.password = password;
}
public RegisterRequest() {
	super();

}

public String getUsername() {
	return username;
}
public void setEmail(String email) {
	this.username = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "RegisterRequest [email=" + username + ", password="
			+ password + "]";
}



}
