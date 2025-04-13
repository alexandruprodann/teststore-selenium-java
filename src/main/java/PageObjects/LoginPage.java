package PageObjects;

import Utilities.BaseClass;
import Utilities.LocatorFactory;
import org.openqa.selenium.By;

import static Utilities.LocatorFactory.LocatorType.CSS_SELECTOR;

public class LoginPage extends BaseClass {

    // Elements
    private By emailField() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input#field-email");
    }

    private By passwordField() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input#field-password");
    }

    private By loginBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "button#submit-login");
    }

    private By createAccountLink() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".no-account a");
    }

    public By signOutBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".logout");
    }

    public By authFailedAlert() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".alert.alert-danger");
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
