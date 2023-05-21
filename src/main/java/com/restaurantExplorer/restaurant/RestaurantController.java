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
    

	private RestaurantService restaurantService;
	private RestaurantRepository restaruantRepository;

	public RestaurantController(RestaurantService restaurantService, RestaurantRepository restaruantRepository) {
		super();
		this.restaurantService = restaurantService;
		this.restaruantRepository = restaruantRepository;
	}

	@GetMapping("/users/{username}/restaurants")
	public List<RestaurantDTO> getRestaurants(@PathVariable String username) {
		System.out.println(username);
	    // GET ALL FOR NOW BUT LATER DO BY USERNAME
		 List<Restaurant> restaurant = restaruantRepository.findAll();
		 restaurantService.getAllRestaurantsFromYelpGoogle(restaurant);
		return 	null;
				//new ResponseEntity<RestaurantDTO>(restaruant, HttpStatus.OK);
		//	
				//
		
	}
	
	@PostMapping("/users/{username}/restaurants")// RETURN SUCESS MESSAGE RESOONSE?
	public String createRestaurants(@PathVariable String username, @RequestBody String restaurantBody) {
		
		Restaurant restaurant = new Restaurant(restaurantBody);
		System.out.println(restaurantBody);
		restaruantRepository.save(restaurant);
		return null;// RETURN SUCESS MESSAGE RESOONSE?
	}
	
	@GetMapping("/restaurants")
	public String getAllRestaurants() {
		  String test =	restaurantService.getAllRestaurants();
	
		
			// Return RESPONSE ENTITY?
			return 	test; 		//new ResponseEntity<RestaurantDTO>(restaruant, HttpStatus.OK);

				//new ResponseEntity<RestaurantDTO>(restaruant, HttpStatus.OK);

	}
	

		
	
	
}
