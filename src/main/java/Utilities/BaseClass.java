package Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.ThreadLocalRandom;

public class BaseClass extends Waiters {

    private WebDriver driver;
    protected ThreadLocalRandom random;

    public BaseClass() {
        this.random = ThreadLocalRandom.current();
    }

    @BeforeMethod
    public void setUp() {
        WebDriverFactory.initializeDriver();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }

    public WebDriver getDriver() {
        if (this.driver == null) {
            this.driver = WebDriverFactory.getDriver();
        }
        return this.driver;
    }
}
