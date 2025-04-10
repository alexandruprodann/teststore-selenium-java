package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends BaseClass {

    // Elements
    private By subjectSelect() {
        return By.cssSelector("select#id_contact");
    }

    private By emailField() {
        return By.cssSelector("input#email");
    }

    private By messageField() {
        return By.cssSelector("textarea#contactform-message");
    }

    private By sendButton() {
        return By.cssSelector("input[name='submitMessage']");
    }

    public By successAlert() {
        return By.cssSelector(".alert-success");
    }


    // Actions
    public void chooseDropdownOption(String option) {
        waitUntilElementIsVisible(subjectSelect());
        Select select = new Select(getDriver().findElement(subjectSelect()));
        select.selectByVisibleText(option);
    }

    public void enterEmailAddress(String email) {
        waitUntilElementIsVisible(emailField());
        getDriver().findElement(emailField()).sendKeys(email);
    }

    public void enterTestMessage() {
        waitUntilElementIsVisible(messageField());
        getDriver().findElement(messageField()).sendKeys("This is a test inquiry.");
    }

    public void clickSendBtn() {
        waitUntilElementIsClickable(sendButton());
        getDriver().findElement(sendButton()).click();
    }
}
