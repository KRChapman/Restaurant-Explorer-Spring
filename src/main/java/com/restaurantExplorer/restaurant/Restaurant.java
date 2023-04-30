package com.restaurantexplorer.restaurant;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Restaurant {
	@Id
	@GeneratedValue
	private int Id;
	
	private String googlePlaceId;
	private String yelpPlaceId;
	private String healthPlace;
	
	
	
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
	//	{"googlePlace":{"placeId":"ChIJ1V3f2FNYwokR7O8S9HR4sHc","name":"Nuts 4 Nuts","rating":4.5,"photo":{"height":313,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/108932269284487590140\">A Google User</a>"],"width":350},"address":"610 W 46th St","reviewsTotal":36,"reviews":[{"author_name":"RACC J","author_url":"https://www.google.com/maps/contrib/109487154999105246456/reviews","language":"en","profile_photo_url":"https://lh3.googleusercontent.com/a-/ACB-R5T51bgsWTGWYzwBCKThsNgG_-lfC02QeoDQwgAH=s128-c0x00000000-cc-rp-mo-ba6","rating":5,"relative_time_description":"a year ago","text":"All I can say is \"Wow\" - I love New York! Took the family to NYC for Spring Break. We lodged in the Times Square area. Upon touring the City, we kept smelling this sweet and scrumptious aroma, and was lead like cattle to a Nuts4Nuts street vendor! Man, these things are warm, delicious, and are cooked to perfection right in front of you. This is simply a \"must see\" and \"must eat\" if you like nuts! I thought I was going to have to perform an \"intervention\" on my wife, as we made several additional trips back to this location!","time":1648155695},{"author_name":"Anusha Mahin","author_url":"https://www.google.com/maps/contrib/106443848289217164612/reviews","language":"en","profile_photo_url":"https://lh3.googleusercontent.com/a/AGNmyxZf7catUBypEVQMfMK2DugVJzr0Irtwh7RV2wTo=s128-c0x00000000-cc-rp-mo","rating":5,"relative_time_description":"4 months ago","text":"Pretty much every native New Yorker has seen this place at least once while going on a stroll in Manhattan. And my God, the nuts here taste just as delicious as they smell! Many are compelled to this magical food cart by the marvelous aroma every day, and I don’t blame them at all. The nuts are warm, sweet, and almost even addicting! I bought around 5 packs, all for myself when I last went! This is a must stop for anyone who happens to be in Manhattan!","time":1671757509},{"author_name":"Abhilasha Lokannavar","author_url":"https://www.google.com/maps/contrib/113714328677913947892/reviews","language":"en","profile_photo_url":"https://lh3.googleusercontent.com/a-/ACB-R5SV6zK0XLGjQs0E-1sB85FLEvUQk7XnJO-GibUr3NQ=s128-c0x00000000-cc-rp-mo-ba4","rating":5,"relative_time_description":"9 months ago","text":"I love the honey roasted peanuts and make sure to get them from the carts near Times square. $5 for 3 pack of nuts, great value and quality!","time":1656524494},{"author_name":"Partha Jyoti Das","author_url":"https://www.google.com/maps/contrib/102785614119789343572/reviews","language":"en","profile_photo_url":"https://lh3.googleusercontent.com/a-/ACB-R5TlxYuAnTeufZPVFRbdtiXzpZ3NyDX7XcxWkjUY0g=s128-c0x00000000-cc-rp-mo-ba4","rating":5,"relative_time_description":"a week ago","text":"Love it! Ask for the dollar pouch lol","time":1681099027},{"author_name":"Mary Toscano","author_url":"https://www.google.com/maps/contrib/115360940505265156539/reviews","language":"en","profile_photo_url":"https://lh3.googleusercontent.com/a/AGNmyxbfgwkQqym9EgFR3bbD6_EdqqmcDeLNmOnaHCsE=s128-c0x00000000-cc-rp-mo","rating":1,"relative_time_description":"2 months ago","text":"Boxes were open, no receipt to show that I got refunded for candy they didn’t have, chocolate on cashews was turning white because it was old! Everything horrible! I should get my money back! Never order from here again!","time":1675393748}],"url":"https://maps.google.com/?cid=8624525730120921068"},"yelpPlace":{"placeId":"ChIJ1V3f2FNYwokR7O8S9HR4sHc","name":"Nuts 4 Nuts","rating":4,"yelpId":"iPy0iwI6Bty1dzmf2wyGrQ","url":"https://www.yelp.com/biz/nuts-4-nuts-new-york-3?adjust_creative=3LakhGIp1cC_9_bXX34eSw&utm_campaign=yelp_api_v3&utm_medium=api_v3_phone_search&utm_source=3LakhGIp1cC_9_bXX34eSw","reviewCount":40},"healthPlace":{"name":"","recentGrade":"","inspectionHistory":[]},"generalInfo":{"placeId":"ChIJ1V3f2FNYwokR7O8S9HR4sHc","hours":["Monday: 8:00 AM – 9:00 PM","Tuesday: 8:00 AM – 9:00 PM","Wednesday: 8:00 AM – 9:00 PM","Thursday: 8:00 AM – 9:00 PM","Friday: 8:00 AM – 9:00 PM","Saturday: 8:00 AM – 9:00 PM","Sunday: 8:00 AM – 9:00 PM"],"priceLevel":"$","address":"610 W 46th St","website":"http://nuts4nuts.com/","phoneNumber":"(888) 507-5228"},"photo":{"placeId":"ChIJ1V3f2FNYwokR7O8S9HR4sHc","photo":"https://maps.googleapis.com/maps/api/place/js/PhotoService.GetPhoto?1sAUjq9jlRD2a9gMAMVYu4IUL-TJeLvqTx9fBN5Vh1Rd9RN7gffdchEkjaAW10Fl6FMGpKe0SfGMsC8bEgFBdIPuzKuNjZENI8-wSGPis_NsYAoT61q_pCIvVaCqV8Uy5Nv0nYziv7DP-6Imz8tBOYETYXP07ohrasX_f8Mkim7xzyHF7w60tl&3u350&5m1&2e1&callback=none&key=AIzaSyB338bx7FHlNHSz2m6rEoP6V6gb0Vu9w8I&token=15704"}}
	//	var test = {"googlePlace":{"placeId":"ChIJweBJa11FwokR8pKQjOVu788","name":"Nuthut","rating":5,"photo":{"height":2912,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/103496095199256757944\">A Google User</a>"],"width":5184},"address":"6920 5th Ave","reviewsTotal":74,"reviews":[{"author_name":"Alicia Snow","author_url":"https://www.google.com/maps/contrib/103110804046412083201/reviews","language":"en","profile_photo_url":"https://lh3.googleusercontent.com/a-/ACB-R5SkaCvzrPpKr3yctzWjdVaZVOBry99nAAXNykbK4g=s128-c0x00000000-cc-rp-mo-ba3","rating":5,"relative_time_description":"4 months ago","text":"Our family loves this place! I ordered wedding favors for my daughters wedding in Nov 2022. Ordering was easy and they did a great job recommending what chocolates to place in the adorable boxes. When we arrived to pick up, they were ready and the staff is so kind. The feedback from guests was great and they wanted to know where they can get more of the chocolates. I personally love the coffee selection. Thank you 😊","time":1670869071},{"author_name":"Tam B","author_url":"https://www.google.com/maps/contrib/108870146721196110079/reviews","language":"en","profile_photo_url":"https://lh3.googleusercontent.com/a-/ACB-R5RCPbUH8MTPyAjxdtm7owG_AI9Gzlb9tWT_noXxB4Q=s128-c0x00000000-cc-rp-mo-ba5","rating":5,"relative_time_description":"a year ago","text":"My friend and I went in tonight and were astounded by the amount of nuts and treats this store had. The staff are super friendly and Knowledgeable. I am definitely going back to get the BBQ Almonds.  Definitely a gem in Bay Ridge.","time":1641957395},{"author_name":"Ali The Halal Foodie","author_url":"https://www.google.com/maps/contrib/116288273602674457831/reviews","language":"en","profile_photo_url":"https://lh3.googleusercontent.com/a-/ACB-R5TAzWrBuw2GTIx8HOqOou2yLDFpuQTPttBK3x9t=s128-c0x00000000-cc-rp-mo-ba5","rating":5,"relative_time_description":"a year ago","text":"Looking for a Ramadan Gift 🎁?\n\n📍 Nuthut\n6920 5th Ave, Brooklyn, NY 11209\n\nCome to @nuthutbk in Brooklyn. They have Turkish delight, freshly roasted nuts, coffee, and much more. I really loved their BBQ flavored nuts. They even have A wall of imported chocolates. I was like a fat kid in a candy store 😂\n\nDefinitely check them out. And as always, don’t forget to say Bismillah and Alhamdulilah for everything ❤️","time":1649539625},{"author_name":"Gary Kingstone","author_url":"https://www.google.com/maps/contrib/111295647777420271641/reviews","language":"en","profile_photo_url":"https://lh3.googleusercontent.com/a-/ACB-R5QkgYMlqCc-c7qf4D_7ZK4pJ7FznRpnICTfYUQtTg=s128-c0x00000000-cc-rp-mo","rating":5,"relative_time_description":"a month ago","text":"Happen to be in Bay Ridge neighborhood visted this place for my sweet craving , Love this Place , the Person very welcoming with great hospitality, the Place clean , well organized, amazing display of Sweets & Snacks , I Surely look make visit back , Delicious Sweets great to offers to others and enjoy yourself as well 😋😄","time":1678025519},{"author_name":"Shifa H.","author_url":"https://www.google.com/maps/contrib/109188269008129114228/reviews","language":"en","profile_photo_url":"https://lh3.googleusercontent.com/a-/ACB-R5TYBbrCLLZcL4FBZzS5KGm2RBjCe5om12Bz-cLIcQ=s128-c0x00000000-cc-rp-mo","rating":5,"relative_time_description":"a year ago","text":"Lovely, clean, and beautiful store. The chocolate and (halal!) gummy section variety was impressive (and delicious). They also have Turkish delight, freshly roasted nuts, coffee, and baklava, which I would love to try next time. The costumer service was excellent. Looking forward to coming back!","time":1637075112}],"url":"https://maps.google.com/?cid=14983316417469780722"},"yelpPlace":{"placeId":"ChIJweBJa11FwokR8pKQjOVu788","name":"Nuthut","rating":5,"yelpId":"FzPMeBANKOWUeMdNK--S9Q","url":"https://www.yelp.com/biz/nuthut-brooklyn?adjust_creative=3LakhGIp1cC_9_bXX34eSw&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=3LakhGIp1cC_9_bXX34eSw","reviewCount":13},"healthPlace":{"name":"","recentGrade":"","inspectionHistory":[]},"generalInfo":{"placeId":"ChIJweBJa11FwokR8pKQjOVu788","hours":["Monday: 11:00 AM – 10:00 PM","Tuesday: 11:00 AM – 10:00 PM","Wednesday: 11:00 AM – 10:00 PM","Thursday: 11:00 AM – 10:00 PM","Friday: 11:00 AM – 10:00 PM","Saturday: 11:00 AM – 10:00 PM","Sunday: 11:00 AM – 10:00 PM"],"priceLevel":"","address":"6920 5th Ave","website":"http://nuthutusa.com/","phoneNumber":"(718) 333-5052"},"photo":{"placeId":"ChIJweBJa11FwokR8pKQjOVu788","photo":"https://maps.googleapis.com/maps/api/place/js/PhotoService.GetPhoto?1sAUjq9jlohn4hfCKVls7NCAKWvwhQq0ZzWynkG60A7kq3hKb4upylqV9OlHmEX6oce8ZqlrINU4xZiSW4Kce-5Le1aA4McMl2owyeCjgIUR1J3blfBqymCVuEcpPMnr-tOOlOGZ9hnl_85BAptj8Guk9FnN9qdFZk9IZs-KZjB3TFl-bE208L&3u5184&5m1&2e1&callback=none&key=AIzaSyB338bx7FHlNHSz2m6rEoP6V6gb0Vu9w8I&token=75718"}}
      var test = "{\"googlePlace\":{\"placeId\":\"ChIJweBJa11FwokR8pKQjOVu788\",\"name\":\"Nuthut\",\"rating\":5,\"photo\":{\"height\":2912,\"html_attributions\":[\"<a href=\\\"https://maps.google.com/maps/contrib/103496095199256757944\\\">A Google User</a>\"],\"width\":5184},\"address\":\"6920 5th Ave\",\"reviewsTotal\":74,\"reviews\":[{\"author_name\":\"Alicia Snow\",\"author_url\":\"https://www.google.com/maps/contrib/103110804046412083201/reviews\",\"language\":\"en\",\"profile_photo_url\":\"https://lh3.googleusercontent.com/a-/ACB-R5SkaCvzrPpKr3yctzWjdVaZVOBry99nAAXNykbK4g=s128-c0x00000000-cc-rp-mo-ba3\",\"rating\":5,\"relative_time_description\":\"4 months ago\",\"text\":\"Our family loves this place! I ordered wedding favors for my daughters wedding in Nov 2022. Ordering was easy and they did a great job recommending what chocolates to place in the adorable boxes. When we arrived to pick up, they were ready and the staff is so kind. The feedback from guests was great and they wanted to know where they can get more of the chocolates. I personally love the coffee selection. Thank you 😊\",\"time\":1670869071},{\"author_name\":\"Tam B\",\"author_url\":\"https://www.google.com/maps/contrib/108870146721196110079/reviews\",\"language\":\"en\",\"profile_photo_url\":\"https://lh3.googleusercontent.com/a-/ACB-R5RCPbUH8MTPyAjxdtm7owG_AI9Gzlb9tWT_noXxB4Q=s128-c0x00000000-cc-rp-mo-ba5\",\"rating\":5,\"relative_time_description\":\"a year ago\",\"text\":\"My friend and I went in tonight and were astounded by the amount of nuts and treats this store had. The staff are super friendly and Knowledgeable. I am definitely going back to get the BBQ Almonds.  Definitely a gem in Bay Ridge.\",\"time\":1641957395},{\"author_name\":\"Ali The Halal Foodie\",\"author_url\":\"https://www.google.com/maps/contrib/116288273602674457831/reviews\",\"language\":\"en\",\"profile_photo_url\":\"https://lh3.googleusercontent.com/a-/ACB-R5TAzWrBuw2GTIx8HOqOou2yLDFpuQTPttBK3x9t=s128-c0x00000000-cc-rp-mo-ba5\",\"rating\":5,\"relative_time_description\":\"a year ago\",\"text\":\"Looking for a Ramadan Gift 🎁?\\n\\n📍 Nuthut\\n6920 5th Ave, Brooklyn, NY 11209\\n\\nCome to @nuthutbk in Brooklyn. They have Turkish delight, freshly roasted nuts, coffee, and much more. I really loved their BBQ flavored nuts. They even have A wall of imported chocolates. I was like a fat kid in a candy store 😂\\n\\nDefinitely check them out. And as always, don’t forget to say Bismillah and Alhamdulilah for everything ❤️\",\"time\":1649539625},{\"author_name\":\"Gary Kingstone\",\"author_url\":\"https://www.google.com/maps/contrib/111295647777420271641/reviews\",\"language\":\"en\",\"profile_photo_url\":\"https://lh3.googleusercontent.com/a-/ACB-R5QkgYMlqCc-c7qf4D_7ZK4pJ7FznRpnICTfYUQtTg=s128-c0x00000000-cc-rp-mo\",\"rating\":5,\"relative_time_description\":\"a month ago\",\"text\":\"Happen to be in Bay Ridge neighborhood visted this place for my sweet craving , Love this Place , the Person very welcoming with great hospitality, the Place clean , well organized, amazing display of Sweets & Snacks , I Surely look make visit back , Delicious Sweets great to offers to others and enjoy yourself as well 😋😄\",\"time\":1678025519},{\"author_name\":\"Shifa H.\",\"author_url\":\"https://www.google.com/maps/contrib/109188269008129114228/reviews\",\"language\":\"en\",\"profile_photo_url\":\"https://lh3.googleusercontent.com/a-/ACB-R5TYBbrCLLZcL4FBZzS5KGm2RBjCe5om12Bz-cLIcQ=s128-c0x00000000-cc-rp-mo\",\"rating\":5,\"relative_time_description\":\"a year ago\",\"text\":\"Lovely, clean, and beautiful store. The chocolate and (halal!) gummy section variety was impressive (and delicious). They also have Turkish delight, freshly roasted nuts, coffee, and baklava, which I would love to try next time. The costumer service was excellent. Looking forward to coming back!\",\"time\":1637075112}],\"url\":\"https://maps.google.com/?cid=14983316417469780722\"},\"yelpPlace\":{\"placeId\":\"ChIJweBJa11FwokR8pKQjOVu788\",\"name\":\"Nuthut\",\"rating\":5,\"yelpId\":\"FzPMeBANKOWUeMdNK--S9Q\",\"url\":\"https://www.yelp.com/biz/nuthut-brooklyn?adjust_creative=3LakhGIp1cC_9_bXX34eSw&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=3LakhGIp1cC_9_bXX34eSw\",\"reviewCount\":13},\"healthPlace\":\r\n"
      		+ "{\"name\":\"\",\"recentGrade\":\"\",\"inspectionHistory\":[]},\"generalInfo\":{\"placeId\":\"ChIJweBJa11FwokR8pKQjOVu788\",\"hours\":[\"Monday: 11:00 AM – 10:00 PM\",\"Tuesday: 11:00 AM – 10:00 PM\",\"Wednesday: 11:00 AM – 10:00 PM\",\"Thursday: 11:00 AM – 10:00 PM\",\"Friday: 11:00 AM – 10:00 PM\",\"Saturday: 11:00 AM – 10:00 PM\",\"Sunday: 11:00 AM – 10:00 PM\"],\"priceLevel\":\"\",\"address\":\"6920 5th Ave\",\"website\":\"http://nuthutusa.com/\",\"phoneNumber\":\"(718) 333-5052\"},\"photo\":{\"placeId\":\"ChIJweBJa11FwokR8pKQjOVu788\",\"photo\":\"https://maps.googleapis.com/maps/api/place/js/PhotoService.GetPhoto?1sAUjq9jlohn4hfCKVls7NCAKWvwhQq0ZzWynkG60A7kq3hKb4upylqV9OlHmEX6oce8ZqlrINU4xZiSW4Kce-5Le1aA4McMl2owyeCjgIUR1J3blfBqymCVuEcpPMnr-tOOlOGZ9hnl_85BAptj8Guk9FnN9qdFZk9IZs-KZjB3TFl-bE208L&3u5184&5m1&2e1&callback=none&key=AIzaSyB338bx7FHlNHSz2m6rEoP6V6gb0Vu9w8I&token=75718\"}}";
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
