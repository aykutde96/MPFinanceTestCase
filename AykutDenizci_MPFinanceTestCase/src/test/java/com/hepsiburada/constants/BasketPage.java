package com.hepsiburada.constants;

import org.openqa.selenium.By;

public class BasketPage {
    public static final By PRODUCT_COUNT = By.cssSelector("input[name='quantity']");
    public static final By PRODUCT_NAME_IN_BASKET = By.xpath("//div[@class='product_name_3Lh3t']/a");
}
