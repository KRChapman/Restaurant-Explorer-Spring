package com.restaurantexplorer.restaurant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Restaurant {
	@Id
	int Id;
	
	private String googlePlaceId;
	private String yelpPlaceId;
	private String healthPlace;
	
	
	
	public Restaurant(int id, String googlePlaceId, String yelpPlaceId, String healthPlace) {
		super();
		Id = id;
		this.googlePlaceId = googlePlaceId;
		this.yelpPlaceId = yelpPlaceId;
		this.healthPlace = healthPlace;
	}

	public int getId() {
		return Id;
	}

	public String getGooglePlaceId() {
		return googlePlaceId;
	}
	public void setGooglePlaceId(String googlePlaceId) {
		this.googlePlaceId = googlePlaceId;
	}
	public String getYelpPlaceId() {
		return yelpPlaceId;
	}
	public void setYelpPlaceId(String yelpPlaceId) {
		this.yelpPlaceId = yelpPlaceId;
	}
	public String getHealthPlace() {
		return healthPlace;
	}
	public void setHealthPlace(String healthPlace) {
		this.healthPlace = healthPlace;
	}



	
}
