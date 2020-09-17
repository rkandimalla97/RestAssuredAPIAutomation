package com.apiautomation.basics;

import org.testng.annotations.Test;

import com.apiautomation.files.Payload;
import com.apiautomation.utilities.CommonMethods;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class PassParamsInDynamiJson {

	/* Dynamically build json payload with parameters*/
	
	public String book_ID;
	
	@Test(priority=1)
	public void createNewBookUsingDynamicJson() {
		RestAssured.baseURI = "http://216.10.245.166/";
		
		String resp = given().log().all().header("Content-Type", "application/json")
				.body(Payload.addNewBook("Head First Java", "code", "423", "Kathy Sierra"))
				.put("Library/Addbook.php")
				.then().assertThat().statusCode(200)
				.extract().response().asString();
		System.out.println("Create New Book response:"+resp);
		JsonPath jsonBody = CommonMethods.convertRawToJson(resp);
		book_ID = jsonBody.get("ID");
		System.out.println("Book Id is:"+book_ID);
	}
	
	/* Once new book is created book_id will be stored as global variable, and by using book_id book record will be deleted immediately*/
	@Test(priority=2)
	public void deleteBook() {
		
		RestAssured.baseURI = "http://216.10.245.166/";
		
		String resp = given().log().all().header("Content-Type", "application/json")
				.body(Payload.deleteBook(book_ID))
				.post("Library/DeleteBook.php")
				.then().assertThat().statusCode(200)
				.extract().response().asString();
		System.out.println("Delete Book response:"+resp);
		
	}
}
