package com.hepsiburada.base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.hepsiburada.constants.HomePageConstant.TITLE;

public class BaseTest {
    public final Logger logger = LogManager.getLogger(BaseTest.class);
    public static WebDriver webDriver;

    @BeforeScenario
    public void setUp() {
        logger.info("----- Test is starting -----");
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("96");
        options.setPlatformName("Windows");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-fullscreen");
        WebDriverManager.chromedriver().setup();
        setWebDriver(new ChromeDriver(options));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3));
        webDriver.manage().timeouts().scriptTimeout(Duration.ofMinutes(3));
        webDriver.navigate().to("https://www.hepsiburada.com");
        Assert.assertEquals(TITLE, webDriver.getTitle());
    }

    @AfterScenario
    public void tearDown() {
        webDriver.quit();
        logger.info("----- Test Finished -----");
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        BaseTest.webDriver = webDriver;
    }
}
