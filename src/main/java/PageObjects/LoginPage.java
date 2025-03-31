package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;

public class LoginPage extends BaseClass {

    // Elements
    private By emailField() {
        return By.cssSelector("input#field-email");
    }

    private By passwordField() {
        return By.cssSelector("input#field-password");
    }

    private By loginBtn() {
        return By.cssSelector("button#submit-login");
    }

    private By createAccountLink() {
        return By.cssSelector(".no-account a");
    }

    public By signOutBtn() {
        return By.cssSelector(".logout");
    }


    // Actions
    public void enterEmail(String email) {
        waitUntilElementIsVisible(emailField());
        getDriver().findElement(emailField()).sendKeys(email);
    }

    public void enterPassword(String password) {
        waitUntilElementIsVisible(passwordField());
        getDriver().findElement(passwordField()).sendKeys(password);
    }

    public void clickLogin() {
        waitUntilElementIsClickable(loginBtn());
        getDriver().findElement(loginBtn()).click();
    }

    public void clickCreateAccountLink() {
        waitUntilElementIsClickable(createAccountLink());
        getDriver().findElement(createAccountLink()).click();
    }

    public void loginAs(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
}
