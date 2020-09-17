package com.apiautomation.basics;

import org.testng.annotations.Test;

import com.apiautomation.files.Payload;

import io.restassured.path.json.JsonPath;

public class ValidationOfBookStoreAPI {

	@Test
	public void getBookPrice () {
		
		//get the payload and store in json object
		JsonPath jsonBody = new JsonPath(Payload.bookStore());
		
		//get no of books by API
		int count = jsonBody.getInt("books.size()");
		System.out.println("No of books in API:"+count);
		
		//get price of book based on title
		for(int i=0;i<count;i++) {
			
			if(jsonBody.getString("books["+i+"].title").equalsIgnoreCase("The Definitive Guide to MongoDB, 3rd Edition")) {
				String book_price = jsonBody.get("books["+i+"].price");
				System.out.println("Title of book is:"+jsonBody.getString("books["+i+"].title")+" and Book pirce is:"+book_price);
			}
		}
	}
}
