package TestStore;

import PageObjects.BasePage;
import Utilities.WebDriverManager;
import org.testng.annotations.*;

public class BaseTest extends BasePage {

        @BeforeTest
        public void setUp() {
            WebDriverManager.initializeDriver();
        }

        @AfterTest
        public void tearDown() {
            WebDriverManager.quitDriver();
        }
}
