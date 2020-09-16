package com.apiautomation.utilities;

import io.restassured.path.json.JsonPath;

public class CommonMethods {

	
	public static JsonPath convertRawToJson(String response)
	{
		JsonPath js1 =new JsonPath(response);
		return js1;
	}
}
