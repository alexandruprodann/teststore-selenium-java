package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.GregorianCalendar;
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
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            TakesScreenshot screenshot = (TakesScreenshot) getDriver();
            File file = screenshot.getScreenshotAs(OutputType.FILE);

            String failureImageFileName = "Screenshots" + File.separator
                    + result.getMethod().getMethodName()
                    + "_"
                    + new SimpleDateFormat("dd-MM-yyyy_HH-mm").format(new GregorianCalendar().getTime())
                    + ".png";

            try {
                FileUtils.copyFile(file, new File(failureImageFileName));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


       quitDriver();
    }


    // Test Utils
    /**
     * Checks if test is made for mobile
     *
     * @return boolean
     */
    public static boolean isMobile() {
        return Arrays.asList(Reporter.getCurrentTestResult().getMethod().getGroups()).contains(Platform.MOBILE);
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

    /**
     * Is element displayed
     *
     * @param element By
     * @return boolean
     */
    public boolean isElementDisplayed(By element) {
        try {
            waitUntilElementIsVisible(element);
            return getDriver().findElement(element).isDisplayed();
        } catch (TimeoutException | NoSuchElementException exception) {
            return false;
        }
    }

    /**
     * Scroll to element center with Javascript
     *
     * @param locator By
     */
    public void scrollToElementCenter(By locator) {
        try {
            WebElement element = getDriver().findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.out.println("No such element exception " + locator);
        }
    }

    /**
     * Element click with Javascript
     *
     * @param locator By
     */
    public void jsClick(By locator) {
        WebElement element = getDriver().findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * Extract numeric price (double) from text of element
     *
     * @param locator By
     * @return price as 'double'
     */
    public double getPriceFromElement(By locator) {
        String priceText = getDriver().findElement(locator).getText();
        return Double.parseDouble(priceText.replace("$", ""));
    }

    /**
     * Random email generator
     *
     * @return String
     */
    public String generateRandomEmail() {
        return generateRandomString() + "@test.com";
    }

    /**
     * Random password generator
     *
     * @return String
     */
    public String generateRandomPassword() {
        return generateRandomString() + "test1!";
    }

    /**
     * Random string generator
     *
     * @return String
     */
    public String generateRandomString() {
        final String letterString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder s = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            int ch = (int) (letterString.length() * Math.random());
            s.append(letterString.charAt(ch));
        }

        return s.toString();
    }

    /**
     * Get text from element
     *
     * @param locator By
     * @return String
     */
    public String getTextFromElement(By locator) {
        waitUntilElementIsVisible(locator);
        return getDriver().findElement(locator).getText();
    }

    /**
     * Get attribute from element
     *
     * @param locator By
     * @param attribute String
     * @return String
     */
    public String getAttributeFromElement(By locator, String attribute) {
        waitUntilElementIsVisible(locator);
        return getDriver().findElement(locator).getDomAttribute(attribute);
    }

    /**
     * Checks if a link is valid
     *
     * @param url link
     * @return boolean
     */
    public boolean isLinkValid(String url) {
        try {
            URI uri = new URI(url);
            URL validatedURL = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) validatedURL.openConnection();

            connection.setConnectTimeout(3000);
            connection.connect();

            int responseCode = connection.getResponseCode();

            return responseCode >= 200 && responseCode < 400;
        } catch (Exception e) {
            return false;
        }
    }
}
