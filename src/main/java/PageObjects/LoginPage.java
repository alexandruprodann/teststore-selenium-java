package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    // Elements
    private By emailFieldBy() {
        return By.cssSelector("input#field-email");
    }

    private By passwordFieldBy() {
        return By.cssSelector("input#field-password");
    }

    private By loginBtnBy() {
        return By.cssSelector("button#submit-login");
    }


    // Actions
    public void enterEmail(String email) {
        waitUntilElementIsVisible(emailFieldBy());
        driver.findElement(emailFieldBy()).sendKeys(email);
    }

    public void enterPassword(String password) {
        waitUntilElementIsVisible(passwordFieldBy());
        driver.findElement(passwordFieldBy()).sendKeys(password);
    }

    public void clickLogin() {
        waitUntilElementIsClickable(loginBtnBy());
        driver.findElement(loginBtnBy()).click();
    }
}
