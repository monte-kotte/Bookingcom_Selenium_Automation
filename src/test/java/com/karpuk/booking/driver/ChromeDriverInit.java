package com.karpuk.booking.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChromeDriverInit {

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static WebDriver driver;

    private ChromeDriverInit() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            if(System.getProperty(WEBDRIVER_CHROME_DRIVER) == null) {
                System.setProperty(WEBDRIVER_CHROME_DRIVER, System.getenv(WEBDRIVER_CHROME_DRIVER));
            }
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

}