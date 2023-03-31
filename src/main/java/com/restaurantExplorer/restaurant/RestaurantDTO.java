package com.restaurantexplorer.restaurant;

public class RestaurantDTO {
	String googlePlaceId;

	public RestaurantDTO(String googlePlaceId) {
		super();
		this.googlePlaceId = googlePlaceId;
	}
	

	public String getGooglePlaceId() {
		return googlePlaceId;
	}

	public void setGooglePlaceId(String googlePlaceId) {
		this.googlePlaceId = googlePlaceId;
	}


}
