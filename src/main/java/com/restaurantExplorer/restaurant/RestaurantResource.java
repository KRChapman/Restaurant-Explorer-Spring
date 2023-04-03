package com.restaurantexplorer.restaurant;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantResource {

	@GetMapping("/users/{username}/restaurants")
   //
	public List<RestaurantDTO> getRestaurants(@PathVariable String username) {
		RestaurantDTO restaruant = new RestaurantDTO("TestFoo");
	
	
		return 	Arrays.asList(restaruant);
				//new ResponseEntity<RestaurantDTO>(restaruant, HttpStatus.OK);
		//	
				//
		
	}
}
