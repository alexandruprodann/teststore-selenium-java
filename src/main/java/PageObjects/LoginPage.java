package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;

public class LoginPage extends BaseClass {

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

    private By createAccountLinkBy() {
        return By.cssSelector(".no-account a");
    }


    // Actions
    public void enterEmail(String email) {
        waitUntilElementIsVisible(emailFieldBy());
        getDriver().findElement(emailFieldBy()).sendKeys(email);
    }

    public void enterPassword(String password) {
        waitUntilElementIsVisible(passwordFieldBy());
        getDriver().findElement(passwordFieldBy()).sendKeys(password);
    }

    public void clickLogin() {
        waitUntilElementIsClickable(loginBtnBy());
        getDriver().findElement(loginBtnBy()).click();
    }

    public void clickCreateAccountLink() {
        waitUntilElementIsClickable(createAccountLinkBy());
        getDriver().findElement(createAccountLinkBy()).click();
    }

    public void loginAs(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
}
