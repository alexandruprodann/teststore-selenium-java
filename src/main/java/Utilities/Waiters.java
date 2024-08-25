package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Waiters {

    private WebDriverWait wait;

    public Waiters() {
        this.wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(10));
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

}
