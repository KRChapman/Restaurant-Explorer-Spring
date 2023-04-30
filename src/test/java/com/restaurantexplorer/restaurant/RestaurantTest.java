package com.restaurantexplorer.restaurant;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RestaurantTest {

	@Test
	void testRestaurantCreationFromJson() {
		
	    String EXPECTED_STRING = "String Interpolation in Java with some Java examples.";
	    String googlePlaceId = 	"ChIJweBJa11FwokR8pKQjOVu788";
	    String yelpPlaceId = "FzPMeBANKOWUeMdNK--S9Q";
	    String healthPlace = "{\"name\":\"\",\"recentGrade\":\"\",\"inspectionHistory\":[]}";
	 //   String result = String.format("String %1$s in %2$s with some %2$s examples.", first, second);
	
	      var test = String.format("{\"googlePlace\":{\"placeId\":\"%1$s\",\"name\":\"Nuthut\",\"rating\":5,\"photo\":{\"height\":2912,\"html_attributions\":[\"<a href=\\\"https://maps.google.com/maps/contrib/103496095199256757944\\\">A Google User</a>\"],\"width\":5184},\"address\":\"6920 5th Ave\",\"reviewsTotal\":74,\"reviews\":[{\"author_name\":\"Alicia Snow\",\"author_url\":\"https://www.google.com/maps/contrib/103110804046412083201/reviews\",\"language\":\"en\",\"profile_photo_url\":\"https://lh3.googleusercontent.com/a-/ACB-R5SkaCvzrPpKr3yctzWjdVaZVOBry99nAAXNykbK4g=s128-c0x00000000-cc-rp-mo-ba3\",\"rating\":5,\"relative_time_description\":\"4 months ago\","
	      		+ "\"text\":\"Our family loves this place! I ordered wedding favors for my daughters wedding in Nov 2022. Ordering was easy and they did a great job recommending what chocolates to place in the adorable boxes. When we arrived to pick up, they were ready and the staff is so kind. The feedback from guests was great and they wanted to know where they can get more of the chocolates. I personally love the coffee selection. Thank you 😊\",\"time\":1670869071},{\"author_name\":\"Tam B\",\"author_url\":\"https://www.google.com/maps/contrib/108870146721196110079/reviews\",\"language\":\"en\",\"profile_photo_url\":\"https://lh3.googleusercontent.com/a-/ACB-R5RCPbUH8MTPyAjxdtm7owG_AI9Gzlb9tWT_noXxB4Q=s128-c0x00000000-cc-rp-mo-ba5\","
	      		+ "\"rating\":5,\"relative_time_description\":\"a year ago\",\"text\":\"My friend and I went in tonight and were astounded by the amount of nuts and treats this store had. The staff are super friendly and Knowledgeable. I am definitely going back to get the BBQ Almonds.  Definitely a gem in Bay Ridge.\",\"time\":1641957395},{\"author_name\":\"Ali The Halal Foodie\",\"author_url\":\"https://www.google.com/maps/contrib/116288273602674457831/reviews\",\"language\":\"en\",\"profile_photo_url\":\"https://lh3.googleusercontent.com/a-/ACB-R5TAzWrBuw2GTIx8HOqOou2yLDFpuQTPttBK3x9t=s128-c0x00000000-cc-rp-mo-ba5\",\"rating\":5,\"relative_time_description\":\"a year ago\","
	      		+ "\"text\":\"Looking for a Ramadan Gift 🎁?\\n\\n📍 Nuthut\\n6920 5th Ave, Brooklyn, NY 11209\\n\\nCome to @nuthutbk in Brooklyn. They have Turkish delight, freshly roasted nuts, coffee, and much more. I really loved their BBQ flavored nuts. They even have A wall of imported chocolates. I was like a fat kid in a candy store 😂\\n\\nDefng ❤️\",\"time\":1649539625},{\"author_name\":\"Gary Kingstone\",\"author_url\":\"https://www.google.com/maps/contrib/111295647777420271641/reviews\",\"language\":\"en\",\"profile_photo_url\":\"https://lh3.googleusercontent.com/a-/ACB-R5QkgYMlqCc-c7qf4D_7ZK4pJ7FznRpnICTfYUQtTg=s128-c0x00000000-cc-rp-mo\",\"rating\":5,\"relative_time_description\":\"a month ago\",\"text\":\"Hal 😋😄\",\"time\":1678025519},{\"author_name\":\"Shifa H.\",\"author_url\":\"hts\",\"language\":\"en\",\"profile_photo_url\":\"https://lh3.googleusercontent.com/a-/ACB-R5TYBbrCLLZcL4FBZzS5KGm2RBjCe5om12Bz-cLIcQ=s128-c0x00000000-cc-rp-mo\",\"rating\":5,\"relative_time_description\":\"a year ago\",\"text\":\"Lovely, clean, and beautiful store. The chocolate and (halal!) gummy section variety was impressive (and delicious). They also have Turkish delight, freshly roasted nuts, coffee, and baklava, which I would love to try next time. The costumer service was excellent. Looking forward to coming back!\",\"time\":1637075112}],\"url\":\"https://maps.google.com/?cid=14983316417469780722\"},\"yelpPlace\":{\"placeId\":\"ChIJweBJa11FwokR8pKQjOVu788\",\"name\":\"Nuthut\",\"rating\":5,\"yelpId\":\"%2$s\",\"url\":\"https://www.yelp.com/biz/nuthut-brooklyn?adjust_creative=3LakhGIp1cC_9_bXX34eSw&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=3LakhGIp1cC_9_bXX34eSw\",\"reviewCount\":13},\"healthPlace\":\r\n"
	        		+ "%3$s,\"generalInfo\":{\"placeId\":\"ChIJweBJa11FwokR8pKQjOVu788\",\"hours\":[\"Monday: 11:00 AM – 10:00 PM\",\"Tuesday: 11:00 AM – 10:00 PM\",\"Wednesday: 11:00 AM – 10:00 PM\",\"Thursday: 11:00 AM – 10:00 PM\",\"Friday: 11:00 AM – 10:00 PM\",\"Saturday: 11:00 AM – 10:00 PM\",\"Sunday: 11:00 AM – 10:00 PM\"],\"priceLevel\":\"\",\"address\":\"6920 5th Ave\",\"website\":\"http://nuthutusa.com/\",\"phoneNumber\":\"(718) 333-5052\"},\"photo\":{\"placeId\":\"ChIJweBJa11FwokR8pKQjOVu788\",\"photo\":\"https://maps.googleapis.com/maps/api/place/js/PhotoService.GetPhoto?1sAUjq9jlohn4hfCKVls7NCAKWvwhQq0ZzWynkG60A7kq3hKb4upylqV9OlHmEX6oce8ZqlrINU4xZiSW4Kce-5Le1aA4McMl2owyeCjgIUR1J3blfBqymCVuEcpPMnr-tOOlOGZ9hnl_85BAptj8Guk9FnN9qdFZk9IZs-KZjB3TFl-bE208L&3u5184&5m1&2e1&callback=none&key=AIzaSyB338bx7FHlNHSz2m6rEoP6V6gb0Vu9w8I&token=75718\"}}",googlePlaceId,yelpPlaceId,healthPlace);
		Restaurant restaurant = new Restaurant(test);

		assertAll("Should return address of Oracle's headquarter",
			    () -> assertEquals(googlePlaceId, restaurant.getGooglePlaceId()),
			    () -> assertEquals(yelpPlaceId, restaurant.getYelpPlaceId()),
			    () -> assertEquals(healthPlace, restaurant.getHealthPlace())
			);
	}

}
