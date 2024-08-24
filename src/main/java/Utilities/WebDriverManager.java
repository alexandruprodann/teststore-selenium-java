package Utilities;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static void removeDriver() {
        driver.remove();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");

        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().window().setPosition(new Point(-2000, 0));
        webDriver.manage().window().maximize();
        setDriver(webDriver);
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            removeDriver();
        }
    }
}
