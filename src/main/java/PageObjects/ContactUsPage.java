package PageObjects;

import Utilities.BaseClass;
import Utilities.LocatorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static Utilities.LocatorFactory.LocatorType.CSS_SELECTOR;

public class ContactUsPage extends BaseClass {

    // Elements
    private By subjectSelect() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "select#id_contact");
    }

    private By emailField() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input#email");
    }

    private By messageField() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "textarea#contactform-message");
    }

    private By sendButton() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input[name='submitMessage']");
    }

    public By successAlert() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".alert-success");
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
