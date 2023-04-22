package com.restaurantexplorer.restaurant;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Restaurant {
	@Id
	private int Id;
	
	private String googlePlaceId;
	private String yelpPlaceId;
	private String healthPlace;
	
	
	
	public Restaurant(String restaurantPLace) {
		super();
		// use json/jackson to parse through String restaurantPLace and build
		/// string reprsendations and get placeIds
		//// if any proprty does not exists just return empty string 
		try {
			JsonNode restaurant = createRestaurantNode(restaurantPLace);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Id = id;
//		this.googlePlaceId = googlePlaceId;
//		this.yelpPlaceId = yelpPlaceId;
//		this.healthPlace = healthPlace;
	}
	
	private JsonNode createRestaurantNode(String restaurantPLace) throws JsonMappingException, JsonProcessingException {
	  	ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(restaurantPLace);
       JsonNode quiz = jsonNode.get("quiz");
		return null; // return json node
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
