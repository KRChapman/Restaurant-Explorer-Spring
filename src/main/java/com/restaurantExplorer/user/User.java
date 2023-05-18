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


@Entity
@Table(name = "_user") 
public class User implements UserDetails  {
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	  @Id
	  @GeneratedValue
	  private Integer id;

	  private String username;
	  private String password;

	  public User(Integer id,String username, String password
			  ,Role role) { 
		super();
		this.id = id;
	
		this.username = username;
		this.password = password;
		this.role = role;

	}
	  public User() {
		super();

	}
	@Enumerated(EnumType.STRING)
	  private Role role;


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
	    return username;
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


	public void setUsername(String username) {
		this.username = username;
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


	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User {id:" + id + ", username:" + username + ", password:" + password + ", role:" + role + "}";
	}

	  
	}
