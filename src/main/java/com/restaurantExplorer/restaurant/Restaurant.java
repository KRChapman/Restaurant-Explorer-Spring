package com.restaurantexplorer.restaurant;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurantexplorer.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Restaurant {
	@Id
	@GeneratedValue
	private int Id;
	
	private String googlePlaceId;
	private String yelpPlaceId;
	@Column(columnDefinition="varchar(65530)") 
	private String healthPlace;
	
//	@ManyToOne(fetch = FetchType.LAZY)	
//	private User user;
	
	public Restaurant(String restaurantPLace) {
		super();

		String googlePlaceId = "";
		String yelpPlaceId = "";
		String healthPlace = "";
		JsonNode restaurant = null;
		
		try {
			 restaurant = createRestaurantNode(restaurantPLace);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		if(restaurant != null) {
			googlePlaceId = restaurant.get("googlePlace").get("placeId").asText();
			yelpPlaceId = restaurant.get("yelpPlace").get("yelpId").asText();
			healthPlace = restaurant.get("healthPlace").toString();
			System.out.println(restaurant);
		}
		
//		Id = id;
		this.googlePlaceId = googlePlaceId;
		this.yelpPlaceId = yelpPlaceId;
		this.healthPlace = healthPlace;
	}
	
	private JsonNode createRestaurantNode(String restaurantPLace) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(restaurantPLace);


		return jsonNode; 
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

	@Override
	public String toString() {
		return "Restaurant [Id=" + Id + ", googlePlaceId=" + googlePlaceId + ", yelpPlaceId=" + yelpPlaceId
				+ ", healthPlace=" + healthPlace + "]";
	}



	
}
