package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    // Locate elements using @FindBy annotation
    @FindBy(css = "input#field-email")
    private WebElement emailField;

    @FindBy(css = "input#field-password")
    private WebElement passwordField;

    @FindBy(css = "button#submit-login")
    private WebElement loginBtn;


    /*
    *
    * Actions
    *
    * */
    public void enterEmail(String email) {
        waitForVisibility(emailField);
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        waitForVisibility(emailField);
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        waitForClickable(loginBtn);
        loginBtn.click();
    }
}
