package com.example.Prep.constants;

/**
 * This is the constants file which holds all the constants used in the
 * application.
 * 
 * @author Manas Vishnoi
 */
public class Constants {

	public static final String CREATE_CUSTOMER_URL = "customer/new/create";
	public static final String FETCH_CUSTOMER_DETAIL_URL = "customer/fetch";
	public static final String CHECK_IF_CUSTOMER_EXISTS = "/fetch/user/exists/{email}";

	public static final String OPEN_AI_IMAGE_GENERATION_URL = "/customer/questions/image/openai";
	public static final String OPEN_AI_CHAT_RESPONSE_URL = "/customer/questions/chatbot/openai";

}
