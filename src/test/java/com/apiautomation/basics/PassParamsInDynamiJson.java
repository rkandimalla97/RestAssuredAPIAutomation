package com.apiautomation.basics;

import org.testng.annotations.Test;

import com.apiautomation.constants.APIConstants;
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
		RestAssured.baseURI = APIConstants.BOOK_BASE_URI;
		
		String resp = given().log().all().header(APIConstants.HEADER_CONTENT_TYPE, APIConstants.HEADER_CONTENT_TYPE_JSON)
				.body(Payload.addNewBook("Head First Java", "code", "423", "Kathy Sierra"))
				.put(APIConstants.ADDBOOK_RESOURCE)
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
		
		RestAssured.baseURI = APIConstants.BOOK_BASE_URI;
		
		String resp = given().log().all().header(APIConstants.HEADER_CONTENT_TYPE, APIConstants.HEADER_CONTENT_TYPE_JSON)
				.body(Payload.deleteBook(book_ID))
				.post(APIConstants.DELETEBOOK_RESOURCE)
				.then().assertThat().statusCode(APIConstants.STATUS_CODE_200)
				.extract().response().asString();
		System.out.println("Delete Book response:"+resp);
		
	}
}
