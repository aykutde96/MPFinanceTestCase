package com.hepsiburada.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class BasePage extends BaseTest {
    public final Logger logger = LogManager.getLogger(BasePage.class);
    WebDriverWait webDriverWait;
    WebDriver webDriver;

    public BasePage() {
        webDriver = BaseTest.webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5), Duration.ofSeconds(5));
    }

    public WebElement findElement(By by) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        logger.info("Element bulundu");
        return webDriver.findElement(by);
    }

    public void clickElement(By by) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
        logger.info("Elemente tıklandı");
    }

    public void sendKeys(By by, String product) {
        findElement(by).sendKeys(product);
        logger.info("Elemente '{}' değeri yazıldı", product);
    }

    //ürünü ekledikten sonra açılan pop-upın görünürlüğünü beklemek için eklendi
    public void waitVisibility(By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        logger.info("Element görünebilir olana kadar beklendi");
    }

    public List<WebElement> findElements(By by) {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        logger.info("Element listesi bulundu");
        return webDriver.findElements(by);
    }

    // ürüne tıkladıktan sonra yeni sekmeye geçtiğimizden dolayı eklendi
    public void randomClickAndRedirectNewTab(By by) {
        Random random = new Random();
        WebElement element = findElements(by).get(random.nextInt(findElements(by).size()));
        String originalWindow = webDriver.getWindowHandle();
        assert webDriver.getWindowHandles().size() == 1;
        element.click();
        webDriverWait.until(numberOfWindowsToBe(2));
        logger.info("Sekme sayısı 2 olana kadar beklendi");
        for (String windowHandle : webDriver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                webDriver.switchTo().window(windowHandle);
                logger.info("Yeni sekmeye geçildi");
                break;
            }
        }
    }

    // Arama yaparken önerilen kelimelerin marklı kısmı yazdığım kelimeye eşit mi kontrolü için
    public void checkListTexts(By by, String text) {
        for (int i = 0; i < findElements(by).size(); i++) {
            Assert.assertEquals(findElements(by).get(i).getText().toLowerCase(), text.toLowerCase());
        }
        logger.info("Listedeki elementlerin textleri '{}' değerine eşit mi kontrol edildi", text);
    }

    public void checkElementText(By by, String text) {
        Assert.assertEquals(findElement(by).getText().toLowerCase(), text.toLowerCase());
        logger.info("Elementin texti '{}' değerine eşit mi kontrol edildi", text);
    }

    // ürün sayfasının url'si ürün adını içeriyor mu kontrolü
    public void checkURLContains(String text) {
        Assert.assertTrue(webDriver.getCurrentUrl().contains(text.toLowerCase()));
        logger.info("Url '{}' değerini içeriyor mu kontrol edildi", text);
    }

    public void waitUntilTextToBe(By by, String text) {
        webDriverWait.until(ExpectedConditions.textToBe(by, text));
        logger.info("Elementin texti '{}' olana kadar beklendi", text);
    }
}
