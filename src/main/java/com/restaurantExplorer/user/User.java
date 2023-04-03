package com.restaurantexplorer.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//public class User {
//
//}

@Entity
@Table(name = "_user") // Change name to not clash?
public class User implements UserDetails  {
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	  @Id
	  @GeneratedValue
	  private Integer id;
	  private String firstname;
	  private String lastname;
	  private String email;
	  private String password;

	  public User(Integer id, String firstname, String lastname, String email, String password
			  ,Role role) { //, Role role,	List<Token> tokens
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.role = role;
//		this.tokens = tokens;
	}
	  public User() {
		super();

	}
	@Enumerated(EnumType.STRING)
	  private Role role;

//	  @OneToMany(mappedBy = "user")
//	  private List<Token> tokens;
//
	  @Override
	  public Collection<? extends GrantedAuthority> getAuthorities() {
	    return List.of(new SimpleGrantedAuthority(role.name()));
	  }
	  @Override
	  public String getPassword() {
	    return password;
	  }

	  @Override
	  public String getUsername() {
	    return email;
	  }

	  @Override
	  public boolean isAccountNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isAccountNonLocked() {
	    return true;
	  }

	  @Override
	  public boolean isCredentialsNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isEnabled() {
	    return true;
	  }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
//
//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}
//
//	public List<Token> getTokens() {
//		return tokens;
//	}
//
//	public void setTokens(List<Token> tokens) {
//		this.tokens = tokens;
//	}

	public void setPassword(String password) {
		this.password = password;
	}

	  
	}
