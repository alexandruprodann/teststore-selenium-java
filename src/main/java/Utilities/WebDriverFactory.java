package Utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeDriver(String platform) {
        if (driver.get() == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-search-engine-choice-screen");

            if (isHeadless()) {
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920, 1080");
            }

            WebDriver webDriver;

            switch (platform) {
                case Platform.MOBILE:
                    Map<String, String> mobileEmulation = new HashMap<>();
                    mobileEmulation.put("deviceName", "iPhone 12 Pro");
                    options.setExperimentalOption("mobileEmulation", mobileEmulation);
                    webDriver = new ChromeDriver(options);
                    webDriver.manage().window().setSize(new Dimension(420, 1000));
                    break;

                case Platform.PC:
                    webDriver = new ChromeDriver(options);
                    webDriver.manage().window().setPosition(new Point(-2000, 0));
                    webDriver.manage().window().maximize();
                    break;

                default:
                    throw new IllegalArgumentException("Invalid platform: " + platform);
            }

            driver.set(webDriver);
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

    public static boolean isHeadless() {
        try {
            String headlessParam = Reporter.getCurrentTestResult()
                    .getTestContext()
                    .getCurrentXmlTest()
                    .getParameter("headless");

            return headlessParam.equalsIgnoreCase("true");
        } catch (Exception e) {
            return false;
        }
    }
}
