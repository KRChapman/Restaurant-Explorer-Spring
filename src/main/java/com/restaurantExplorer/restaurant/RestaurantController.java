package com.restaurantexplorer.restaurant;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class RestaurantController {
    

	RestaurantService restaurantService;

	public RestaurantController(RestaurantService restaurantService) {
		super();
		this.restaurantService = restaurantService;
	}

	@GetMapping("/users/{username}/restaurants")
	public List<RestaurantDTO> getRestaurants(@PathVariable String username) {
	
	
		return 	null;
				//new ResponseEntity<RestaurantDTO>(restaruant, HttpStatus.OK);
		//	
				//
		
	}
	
	@PostMapping("/users/{username}/restaurants")
	public String createRestaurants(@PathVariable String username, @RequestBody String restaurant) {
		System.out.println(restaurant);
		return restaurant;
	}
	
	@GetMapping("/restaurants")
	public String getAllRestaurants() {
		  String test =	restaurantService.getAllRestaurants();
	
		
			// Return RESPONSE ENTITY?
			return 	test; 		//new ResponseEntity<RestaurantDTO>(restaruant, HttpStatus.OK);

				//new ResponseEntity<RestaurantDTO>(restaruant, HttpStatus.OK);

	}
	

		
	
	
}
