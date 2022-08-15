package com.hepsiburada.constants;

public class ApiBaseConstants {
    public static final String GET_ERROR_BODY = "{\"status\":\"Error\",\"message\":\"The grocery item does not found\"}";
    public static final String POST_ID_MISSING_ERROR = "{\"status\":\"Error\",\"message\":\"Id is required parameter\"}";
    public static final String POST_NAME_MISSING_ERROR = "{\"status\":\"Error\",\"message\":\"Name is required parameter\"}";
    public static final String POST_PRICE_MISSING_ERROR = "{\"status\":\"Error\",\"message\":\"Price is required parameter\"}";
    public static final String POST_STOCK_MISSING_ERROR = "{\"status\":\"Error\",\"message\":\"Stock is required parameter\"}";
    public static final String POST_SUCCESSFUL_MESSAGE = "{\"status\":\"Success\",\"message\":\"Item has been added successfully\"}";
}
