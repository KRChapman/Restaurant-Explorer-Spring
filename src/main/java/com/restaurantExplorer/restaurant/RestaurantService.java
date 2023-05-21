package com.restaurantexplorer.restaurant;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

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
	OkHttpClient client = new OkHttpClient().newBuilder().build();
	
	
	public List<RestaurantDTO> getAllRestaurantsFromYelpGoogle(List<Restaurant> restaurants) {
		String yelp = "https://api.yelp.com/v3/businesses/";
	//	CompletableFuture<String> completableFutureResultObj2 = getAllGoogleData().thenApply(data -> data);
		return null;
	}

	public CompletableFuture<String> getAllGoogleData(String id) {
		return CompletableFuture.supplyAsync(() ->  getGoogleData(id));

	}

	public String getGoogleData(String id) {

		String KEY = environment.getProperty("GOOGLE_KEY");
        String googleAPI = "https://maps.googleapis.com/maps/api/place/details/json?";
        String fields = "&fields=name%2Crating%2Cformatted_phone_number";
        String placeId = "place_id="+id;	
        String googleKey = "&key="+KEY;
        
        StringBuilder builder = new StringBuilder();
        builder.append(googleAPI)
          .append(fields)
          .append(placeId)
          .append(googleKey);
  
        String resultURL = builder.toString();
       
        //String formatedForApiCall = String.format("https://maps.googleapis.com/maps/api/place/details/json?place_id=ChIJN1t_tDeuEmsRUsoyG83frY4&fields=name%2Crating%2Cformatted_phone_number&key=", first, second);	
		MediaType mediaType = MediaType.parse("text/plain");
//						@SuppressWarnings("deprecation")
//						RequestBody body = RequestBody.create(mediaType, "");
		Request request = new Request.Builder().url(resultURL)

				.get()

				// .method("GET", body)
				.build();
		Response response = null;
		String data = "";
		try {
			response = client.newCall(request).execute();
			data = response.body().string();
			// System.out.print(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;



	}

	public String getAllRestaurants() {
		String KEY = environment.getProperty("GOOGLE_KEY");

		OkHttpClient client = new OkHttpClient().newBuilder().build();
		MediaType mediaType = MediaType.parse("text/plain");
//					@SuppressWarnings("deprecation")
//					RequestBody body = RequestBody.create(mediaType, "");
		Request request = new Request.Builder().url(
				"https://maps.googleapis.com/maps/api/place/details/json?place_id=ChIJN1t_tDeuEmsRUsoyG83frY4&fields=name%2Crating%2Cformatted_phone_number&key="
						+ KEY)

				.get()

				// .method("GET", body)
				.build();
		Response response = null;
		String data = "";
		try {
			response = client.newCall(request).execute();
			data = response.body().string();
			// System.out.print(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

		// new ResponseEntity<RestaurantDTO>(restaruant, HttpStatus.OK);
		//
		//

	}
}
