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
        PageFactory.initElements(driver, this);
    }

    // Wait for an element to be visible
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for an element to be clickable
    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToHaveText(WebElement element, String expectedText) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }

    public void waitForTitleToContain(String expectedTitle) {
        wait.until(ExpectedConditions.titleContains(expectedTitle));
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

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

