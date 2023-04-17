package com.restaurantexplorer.restaurant;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class RestaurantService {
	
	@Autowired
	Environment environment;


		public String getAllRestaurants() {
		 String KEY = environment.getProperty("GOOGLE_KEY");

			OkHttpClient client = new OkHttpClient().newBuilder()
					  .build();
					MediaType mediaType = MediaType.parse("text/plain");
//					@SuppressWarnings("deprecation")
//					RequestBody body = RequestBody.create(mediaType, "");
					Request request = new Request.Builder()
					  .url("https://maps.googleapis.com/maps/api/place/details/json?place_id=ChIJN1t_tDeuEmsRUsoyG83frY4&fields=name%2Crating%2Cformatted_phone_number&key="+KEY)
					
					 .get()
					 
					//  .method("GET", body)
					  .build();
					Response	response = null; 
					String data = "";
					try {
						response	= client.newCall(request).execute();
						data = response.body().string();
			     //     System.out.print(data);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            return data;
					
					//new ResponseEntity<RestaurantDTO>(restaruant, HttpStatus.OK);
			//	
					//
			
		}
}
