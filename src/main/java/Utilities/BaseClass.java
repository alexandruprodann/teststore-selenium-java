package Utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


    // Actions
    /**
     * Get text from element
     *
     * @param element Web Element
     * @return String
     */
    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    /**
     * Send ENTER key
     *
     * @param element Web Element
     */
    public void pressEnter(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    /**
     * Navigate to URL
     *
     * @param url String
     */
    public void navigateToUrl(String url) {
        getDriver().get(url);
    }

}
