package com.restaurantexplorer.restaurant;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantResource {

	@GetMapping("/users/{username}/restaurants")
	// ResponseEntity<RestaurantDTO> 
	//List<RestaurantDTO>
	public RestaurantDTO getRestaurants(@PathVariable String username) {
		RestaurantDTO restaruant = new RestaurantDTO("TestFoo");
	
	
		return 	restaruant;
		//		Arrays.asList(restaruant);
				//new ResponseEntity<RestaurantDTO>(restaruant, HttpStatus.OK);
		
	}
}
