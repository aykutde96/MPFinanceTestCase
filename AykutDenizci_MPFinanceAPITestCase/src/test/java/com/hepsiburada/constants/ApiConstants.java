package com.hepsiburada.constants;

public class ApiConstants {
    public static final String SUCCESSFUL_BODY = "{\n" +
            "  \"id\": 4,\n" +
            "  \"name\": \"strawberry\",\n" +
            "  \"price\": 12.3,\n" +
            "  \"stock\": 3\n" +
            "}";
    public static final String BODY_NOT_ID = "{\n" +
            "  \"name\": \"string\",\n" +
            "  \"price\": 12.3,\n" +
            "  \"stock\": 3\n" +
            "}";
    public static final String BODY_NOT_NAME = "{\n" +
            "  \"id\": 4,\n" +
            "  \"price\": 12.3,\n" +
            "  \"stock\": 3\n" +
            "}";
    public static final String BODY_NOT_PRICE = "{\n" +
            "  \"id\": 4,\n" +
            "  \"name\": \"string\",\n" +
            "  \"stock\": 3\n" +
            "}";
    public static final String BODY_NOT_STOCK = "{\n" +
            "  \"id\": 4,\n" +
            "  \"name\": \"string\",\n" +
            "  \"price\": 12.3,\n" +
            "}\n";
}
