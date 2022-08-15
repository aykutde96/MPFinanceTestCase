package com.hepsiburada.base;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class ApiBaseMethods {

    public void checkStatusCode(Response response,int statusCode){
       Assert.assertEquals(response.statusCode(),statusCode);
    }
    public void checkResponseSize(Response response,int size,String value){
        Assert.assertEquals(response.jsonPath().getList(value).size(),size);
    }
    public void checkValueEqualTo(Response response,String value,String expectedValue){
        Assert.assertEquals(response.jsonPath().get(value).toString(),expectedValue);
    }

    public Response post(String url,String body){
       return given()
               .when()
               .body(body)
               .post(url)
                .then()
                .extract()
                .response();
    }

    public void bodyContainsValue(Response response, String value){
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        Assert.assertTrue(bodyAsString.contains(value));
    }

    public Response get(String url){
        return given()
                .when()
                .get(url)
                .then()
                .extract()
                .response();
    }
}
