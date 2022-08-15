package com.hepsiburada.constants;

import org.openqa.selenium.By;

public class ProductPage {
    public static final By PRODUCT_NAME = By.id("product-name");
    public static final By ADD_BASKET = By.id("addToCart");
    public static final By BASKET_POP_UP_TITLE = By.xpath("//span[text()=' Ürün sepetinizde']");
    public static final By GO_TO_BASKET = By.xpath("//*[text()='Sepete git']");
    public static final By CART_ITEM_COUNT = By.id("cartItemCount");
    public static final By MY_BASKET = By.cssSelector("a[href='https://checkout.hepsiburada.com/sepetim']");
}
