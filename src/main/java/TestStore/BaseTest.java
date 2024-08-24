package TestStore;

import PageObjects.BasePage;
import Utilities.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

        @BeforeMethod
        public void setUp() {
            WebDriverManager.initializeDriver();
        }

        @AfterMethod
        public void tearDown() {
            WebDriverManager.quitDriver();
        }

        // Getter method for WebDriver
        public WebDriver getDriver() {
            return WebDriverManager.getDriver();
        }
}
