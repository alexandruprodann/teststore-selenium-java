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
}
