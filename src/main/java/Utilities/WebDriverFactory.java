package Utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeDriver(String device) {
        if (driver.get() == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-search-engine-choice-screen");

            if (device.equals("Mobile")) {
                // Mobile Emulation
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "iPhone 12 Pro");
                options.setExperimentalOption("mobileEmulation", mobileEmulation);

                WebDriver webDriver = new ChromeDriver(options);
                webDriver.manage().window().setSize(new Dimension(420, 1000));
                driver.set(webDriver);
            } else {
                // PC Setup
                WebDriver webDriver = new ChromeDriver(options);
                webDriver.manage().window().setPosition(new Point(-2000, 0));
                webDriver.manage().window().maximize();
                driver.set(webDriver);
            }
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
