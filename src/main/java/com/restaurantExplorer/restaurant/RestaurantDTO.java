package com.restaurantexplorer.restaurant;

public class RestaurantDTO {

	private String generalInfo;
	private String googlePlace;
	private String healthPlace;
	private String yelpPlace;
	public RestaurantDTO(String generalInfo, String googlePlace, String healthPlace, String yelpPlace) {
		super();
		this.generalInfo = generalInfo;
		this.googlePlace = googlePlace;
		this.healthPlace = healthPlace;
		this.yelpPlace = yelpPlace;
	}
	public String getGeneralInfo() {
		return generalInfo;
	}
	public void setGeneralInfo(String generalInfo) {
		this.generalInfo = generalInfo;
	}
	public String getGooglePlace() {
		return googlePlace;
	}
	public void setGooglePlace(String googlePlace) {
		this.googlePlace = googlePlace;
	}
	public String getHealthPlace() {
		return healthPlace;
	}
	public void setHealthPlace(String healthPlace) {
		this.healthPlace = healthPlace;
	}
	public String getYelpPlace() {
		return yelpPlace;
	}
	public void setYelpPlace(String yelpPlace) {
		this.yelpPlace = yelpPlace;
	}
	@Override
	public String toString() {
		return "RestaurantDTO [generalInfo=" + generalInfo + ", googlePlace=" + googlePlace + ", healthPlace="
				+ healthPlace + ", yelpPlace=" + yelpPlace + "]";
	}


}
