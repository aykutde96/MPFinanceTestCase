package com.hepsiburada.steps;

import com.hepsiburada.base.BasePage;
import com.hepsiburada.helper.CacheHelper;
import com.thoughtworks.gauge.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import static com.hepsiburada.constants.HomePageConstant.*;
import static com.hepsiburada.constants.BasketPage.*;
import static com.hepsiburada.constants.ProductPage.*;
import static com.hepsiburada.constants.ProductListPage.*;


public class Steps extends BasePage {
    private final CacheHelper cacheHelper = new CacheHelper();
    public final Logger logger = LogManager.getLogger(Steps.class);

    @Step("<product> ürünü arama alanına yazıldı")
    public void searchProduct(String product) {
        sendKeys(SEARCH_AREA, product);
    }

    @Step("Arama butonuna tıklandı")
    public void clickSearchButton() {
        clickElement(SEARCH_BUTTON);
        logger.info("Arama yapıldı");
    }

    @Step("Önerilen kelimeler <product> içeriyor mu kontrol edildi")
    public void checkSuggestions(String product) {
        checkListTexts(SUGGESTIONS, product);
        logger.info("Önerilen kelimeler '{}' içeriyor mu kontrol edildi",product);
    }

    @Step("<product> sayfasında olduğumuz kontrol edildi")
    public void checkProductPage(String product) {
        checkElementText(SEARCH_RESULT_SUMMARY_BAR, product);
        checkURLContains(product);
        logger.info("'{}' sayfasında olduğumuz kontrol edildi",product);
    }

    @Step("Listeden rastgele ürün seçildi")
    public void pickProduct() {
        randomClickAndRedirectNewTab(PRODUCT_LIST);
        logger.info("Listeden ürün seçildi");
    }

    @Step("Ürün adı <key> olarak kaydedildi")
    public void saveProductName(String key) {
        cacheHelper.globalVariable().put(key, findElement(PRODUCT_NAME).getText().trim());
        logger.info("Ürün '{}' olarak kaydedildi",key);
    }

    @Step("Ürün sepete eklendi")
    public void addBasket() {
        clickElement(ADD_BASKET);
        waitUntilTextToBe(CART_ITEM_COUNT,"1");
        logger.info("Ürün sepete eklendi");
    }

    @Step("Pop up var mı kontrol et ve sepete git")
    public void checkPopUp() {
        // Bazı ürünlerde pop-up gelmediği için try catch eklenmiştir
        try {
            waitVisibility(BASKET_POP_UP_TITLE);
            clickElement(GO_TO_BASKET);
            logger.info("Pop-up geldi ve sepete gidildi");
        } catch (Exception e){
            clickElement(MY_BASKET);
            logger.info("Pop-up gelmedi ve sepete gidildi");
        }
    }

    @Step("Sepetteki ürün <key> mi kontrol edildi")
    public void checkProduct(String key) {
        Assert.assertEquals(cacheHelper.globalVariable().get(key), findElement(PRODUCT_NAME_IN_BASKET).getText().trim());
        logger.info("Sepetteki ürün '{}' mi kontrol edildi",key);
    }
    @Step("Ürün adeti kontrol edildi")
    public void checkProductCount(){
        Assert.assertEquals("1",findElement(PRODUCT_COUNT).getAttribute("value"));
        logger.info("Sepetteki ürün adeti kontrol edildi");
    }
}
