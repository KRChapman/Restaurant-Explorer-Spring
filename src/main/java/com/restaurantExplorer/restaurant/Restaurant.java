package com.restaurantexplorer.restaurant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//@Entity
public class Restaurant {
	@Id
	int Id;
	
	String googlePlaceId;

	public Restaurant(String googlePlaceId) {
		super();
		
		this.googlePlaceId = googlePlaceId;
	}


	
}
