package com.hepsiburada.steps;

import com.hepsiburada.base.ApiBaseMethods;
import com.thoughtworks.gauge.Step;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import static com.hepsiburada.constants.ApiConstants.*;
import static com.hepsiburada.constants.ApiUrlConstants.*;

public class ApiSteps {
    public final Logger logger = LogManager.getLogger(ApiSteps.class);
    private final ApiBaseMethods apiBaseMethods = new ApiBaseMethods();
    Response allGroceries = apiBaseMethods.get(GET_ALL_GROCERY_URL);
    Response firstGrocery = apiBaseMethods.get(GET_FIRST_GROCERY_URL);
    Response secondGrocery = apiBaseMethods.get(GET_SECOND_GROCERY_URL);
    Response addItem = apiBaseMethods.post(ADD_ITEM_URL, SUCCESSFUL_BODY);

    @Step("<groceryType> grocery listesi çekildi ve status kodun <key> olduğu gözlemlendi")
    public void getAllGroceries(String groceryType, int key){
        logger.info("'{}' grocery değeri seçildi",groceryType);
        if (Objects.equals(groceryType, "Tüm")) {
            apiBaseMethods.checkStatusCode(allGroceries, key);
        } else if (Objects.equals(groceryType, "Birinci")) {
            apiBaseMethods.checkStatusCode(firstGrocery, key);
        } else if (Objects.equals(groceryType, "İkinci")) {
            apiBaseMethods.checkStatusCode(secondGrocery, key);
        } else {
            apiBaseMethods.checkStatusCode(apiBaseMethods.get(GET_ALL_GROCERY_URL + "/" + groceryType), key);
        }
        logger.info("Seçilen değere göre status kod kontrol edildi");
    }

    @Step("Grocery listesinin <key> değerinin boyutunun <size> olduğu kontrol edildi")
    public void checkResponseSize(String key, int size) {
        logger.info("Grocery listesinin boyutu kontrol ediliyor");
        apiBaseMethods.checkResponseSize(allGroceries, size, key);
        logger.info("Grocery listesi '{}' değerinin boyutunun '{}' olduğu doğrulandı", key,size);
    }

    @Step("<groceryType> Grocery cevabı <key> parametresini içeriyor mu?")
    public void responseContains(String groceryType, String key) {
        logger.info("'{}' grocery cevabı '{}' parametresi içeriyor mu kontrol ediliyor",groceryType,key);
        if (Objects.equals(groceryType, "Tüm")) {
            apiBaseMethods.bodyContainsValue(allGroceries, key);
        } else if (Objects.equals(groceryType, "Birinci")) {
            apiBaseMethods.bodyContainsValue(firstGrocery, key);
        } else if (Objects.equals(groceryType, "İkinci")) {
            apiBaseMethods.bodyContainsValue(secondGrocery, key);
        } else {
            apiBaseMethods.bodyContainsValue(apiBaseMethods.get(GET_ALL_GROCERY_URL+ "/" + groceryType), key);
        }
        logger.info("'{}' grocery cevabı '{}' parametresi içeriyor mu kontrol edildi",groceryType,key);
    }

    @Step("<groceryType> Grocery cevabının <key> değeri <value> değerine eşit mi")
    public void checkingGroceryValues(String groceryType, String key, String value) {
        logger.info("'{}' grocery cevabının '{}' parametresi '{}' değerine eşit mi kontrol ediliyor",groceryType,key,value);
        if (Objects.equals(groceryType, "Birinci")) {
            apiBaseMethods.checkValueEqualTo(firstGrocery, key, value);
        } else if (Objects.equals(groceryType, "İkinci")) {
            apiBaseMethods.checkValueEqualTo(secondGrocery, key, value);
        } else {
            apiBaseMethods.checkValueEqualTo(apiBaseMethods.get(GET_ALL_GROCERY_URL+ "/" + groceryType), key, value);
        }
        logger.info("'{}' grocery cevabının '{}' parametresi '{}' değerine eşit mi kontrol edildi",groceryType,key,value);
    }
    @Step("Product eklendi ve status kodun <key> geldiği görüldü")
    public void addProduct(int key){
        logger.info("Ürün eklenip status kodu kontrol ediliyor");
        apiBaseMethods.checkStatusCode(addItem,key);
        logger.info("Ürün eklenip status kodu kontrol edildi");
    }
    @Step("<key> parametresi eksik ürün eklendi ve kodun <statusCode> geldiği görüldü")
    public void addMissingProduct(String key,int statusCode){
        logger.info("'{key}' parametresi eksik post cevabının status kodu kontrol ediliyor",key);
        if (Objects.equals(key, "id")) {
            apiBaseMethods.checkStatusCode(apiBaseMethods.post(ADD_ITEM_URL, BODY_NOT_ID),statusCode);
        } else if (Objects.equals(key, "name")) {
            apiBaseMethods.checkStatusCode(apiBaseMethods.post(ADD_ITEM_URL, BODY_NOT_NAME),statusCode);
        }else if (Objects.equals(key, "price")) {
            apiBaseMethods.checkStatusCode(apiBaseMethods.post(ADD_ITEM_URL, BODY_NOT_PRICE),statusCode);
        }else if (Objects.equals(key, "stock")) {
            apiBaseMethods.checkStatusCode(apiBaseMethods.post(ADD_ITEM_URL, BODY_NOT_STOCK),statusCode);
        }
        logger.info("'{key}' parametresi eksik post cevabının status kodu kontrol edildi",key);
    }
    @Step("Post cevabının <key> değeri <value> değerine eşit mi?")
    public void checkPostResponse(String key,String value){
        logger.info("Post cevabının '{key}' değeri kontrol ediliyor",key);
        apiBaseMethods.checkValueEqualTo(addItem, key, value);
        logger.info("Post cevabının '{key}' değeri kontrol edildi",key);
    }
    @Step("<parameter> değeri eksik post cevabının <key> değeri <value> değerine eşit mi?")
    public void checkMissingPostResponse(String parameter,String key,String value){
        logger.info("'{}' değeri eksik requestin '{}' değeri kontrol ediliyor",parameter,key);
        if (Objects.equals(key, "id")) {
            apiBaseMethods.checkValueEqualTo(apiBaseMethods.post(ADD_ITEM_URL,BODY_NOT_ID),key,value);
        } else if (Objects.equals(key, "name")) {
            apiBaseMethods.checkValueEqualTo(apiBaseMethods.post(ADD_ITEM_URL,BODY_NOT_NAME),key,value);
        }else if (Objects.equals(key, "price")) {
            apiBaseMethods.checkValueEqualTo(apiBaseMethods.post(ADD_ITEM_URL,BODY_NOT_PRICE),key,value);
        }else if (Objects.equals(key, "stock")) {
            apiBaseMethods.checkValueEqualTo(apiBaseMethods.post(ADD_ITEM_URL,BODY_NOT_STOCK),key,value);
        }
        logger.info("'{}' değeri eksik requestin '{}' değeri kontrol edildi",parameter,key);
    }
}
