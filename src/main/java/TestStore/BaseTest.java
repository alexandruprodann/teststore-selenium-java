package TestStore;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {
        public WebDriver driver;

        @BeforeClass
        public void setUp() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-search-engine-choice-screen");

            driver = new ChromeDriver(options);
            driver.manage().window().setPosition(new Point(-2000, 0));
            driver.manage().window().maximize();
        }

        @AfterClass
        public void quit() {
            if (driver != null) {
                driver.quit();
            }
        }
}
