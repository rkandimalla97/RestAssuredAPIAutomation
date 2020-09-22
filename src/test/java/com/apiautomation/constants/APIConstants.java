package com.apiautomation.constants;

public class APIConstants {

	public static final String BOOK_BASE_URI = "http://216.10.245.166/";
	public static final String HEADER_CONTENT_TYPE = "Content-Type";
	public static final String HEADER_CONTENT_TYPE_JSON ="application/json";
	public static final String ADDBOOK_RESOURCE = "Library/Addbook.php";
	public static final String DELETEBOOK_RESOURCE = "Library/DeleteBook.php";
	
	//Status codes
	public static final int STATUS_CODE_200 = 200; /* Success Response*/
	public static final int STATUS_CODE_201 = 201; /* Created record*/
	public static final int STATUS_CODE_204 = 204; /* Resource deleted successfully*/
	public static final int STATUS_CODE_400 = 400; /* Bad Request */
	public static final int STATUS_CODE_404 = 404; /* File Not Found */
	public static final int STATUS_CODE_500 = 500; /*Internal Server Error*/
	public static final int STATUS_CODE_503 = 503; /* Service unavailable*/
	
}
