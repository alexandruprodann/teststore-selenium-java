package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public interface Waiters {

    default WebDriverWait waiter() {
        return new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(20));
    }

    /**
     * Wait until element is visible
     *
     * @param element Web Element
     */
    default void waitUntilElementIsVisible(WebElement element) {
        waiter().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait until element is visible by locator
     *
     * @param locator By
     */
    default void waitUntilElementIsVisible(By locator) {
        waiter().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    /**
     * Wait until element is clickable
     *
     * @param element Web Element
     */
    default void waitUntilElementIsClickable(WebElement element) {
        waiter().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Wait until element is clickable by locator
     *
     * @param locator By
     */
    default void waitUntilElementIsClickable(By locator) {
        waiter().until(ExpectedConditions.elementToBeClickable(locator));
    }


    /**
     * Wait for element to have text
     *
     * @param element Web Element
     * @param expectedText String
     */
    default void waitForElementToHaveText(WebElement element, String expectedText) {
        waiter().until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }

    /**
     * Wait for element to have text by locator
     *
     * @param locator Web Element
     * @param expectedText String
     */
    default void waitForElementToHaveText(By locator, String expectedText) {
        waiter().until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
    }


    /**
     * Wait for title to contain
     *
     * @param expectedTitle String
     */
    default void waitForTitleToContain(String expectedTitle) {
        waiter().until(ExpectedConditions.titleContains(expectedTitle));
    }

    /**
     * Wait for title to contain - Boolean
     *
     * @param expectedTitle String
     * @return boolean
     */
    default boolean waitForTitleToContainBool(String expectedTitle) {
        return waiter().until(ExpectedConditions.titleContains(expectedTitle));
    }

    /**
     * Wait for URL to contain
     *
     * @param expectedUrl String
     */
    default void waitForUrlToContain(String expectedUrl) {
        waiter().until(ExpectedConditions.urlContains(expectedUrl));
    }

    /**
     * Wait for URL to contain - Boolean
     *
     * @param expectedUrl String
     * @return Boolean
     */
    default boolean waitForUrlToContainBool(String expectedUrl) {
       return waiter().until(ExpectedConditions.urlContains(expectedUrl));
    }

    /**
     * Wait for URL to be - Boolean
     *
     * @param expectedUrl String
     * @return Boolean
     */
    default boolean waitForUrlToBeBoolean(String expectedUrl) {
        return waiter().until(ExpectedConditions.urlToBe(expectedUrl));
    }

}
