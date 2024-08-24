package TestStore;

import Utilities.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

        @BeforeTest
        public void setUp() {
            WebDriverManager.initializeDriver();
        }

        @AfterTest
        public void tearDown() {
            WebDriverManager.quitDriver();
        }

        public WebDriver getDriver() {
            return WebDriverManager.getDriver();
        }
}
