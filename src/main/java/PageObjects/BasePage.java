package PageObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    Random random = new Random();

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Wait until element is visible
     *
     * @param element Web Element
     */
    public void waitUntilElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait until element is visible by locator
     *
     * @param locator By
     */
    public void waitUntilElementIsVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    /**
     * Wait until element is clickable
     *
     * @param element Web Element
     */
    public void waitUntilElementIsClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Wait until element is clickable by locator
     *
     * @param locator By
     */
    public void waitUntilElementIsClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    /**
     * Wait for element to have text
     *
     * @param element Web Element
     * @param expectedText String
     */
    public void waitForElementToHaveText(WebElement element, String expectedText) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }

    /**
     * Wait for element to have text by locator
     *
     * @param locator Web Element
     * @param expectedText String
     */
    public void waitForElementToHaveText(By locator, String expectedText) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
    }


    /**
     * Wait for title to contain
     *
     * @param expectedTitle String
     */
    public void waitForTitleToContain(String expectedTitle) {
        wait.until(ExpectedConditions.titleContains(expectedTitle));
    }


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


    // Screenshot Taker
    public void takeScreenshot(WebDriver driver) throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("D:/Projects/IntelliJ/seleniumscreenshots/" + timestamp() + " .png");

        FileUtils.copyFile(screenshot, destinationFile);
    }

    public String timestamp() {
        return new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
    }


}

