package Utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class BaseClass extends WebDriverFactory implements Waiters {

    protected ThreadLocalRandom random;
    private String device;

    public BaseClass() {
        this.random = ThreadLocalRandom.current();
    }

    @BeforeMethod
    public void setUp(Method method) {
        Test testAnnotation = method.getAnnotation(Test.class);
        String[] groups = testAnnotation.groups();

        if (Arrays.asList(groups).contains(Platform.MOBILE)) {
            device = Platform.MOBILE;
        } else if (Arrays.asList(groups).contains(Platform.PC)) {
            device = Platform.PC;
        }
        
        initializeDriver(device);
    }

    @AfterMethod
    public void tearDown() {
       quitDriver();
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
