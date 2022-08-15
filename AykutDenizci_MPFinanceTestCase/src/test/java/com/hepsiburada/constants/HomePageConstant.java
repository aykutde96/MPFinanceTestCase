package com.hepsiburada.constants;

import org.openqa.selenium.By;

public class HomePageConstant {
    public static final String TITLE = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
    public static final By SEARCH_AREA = By.cssSelector("input[class='desktopOldAutosuggestTheme-input']");
    public static final By SEARCH_BUTTON = By.cssSelector("div[class='SearchBoxOld-buttonContainer']");
    public static final By SUGGESTIONS = By.cssSelector("mark[class='SuggestionText-highlight ']");
}