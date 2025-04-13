package PageObjects;

import Utilities.BaseClass;
import Utilities.LocatorFactory;
import Utilities.TestConstants;
import org.openqa.selenium.By;

import static Utilities.LocatorFactory.LocatorType.CSS_SELECTOR;

public class PersonalDetailsPage extends BaseClass {

    // Elements
    public By firstNameField() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input#field-firstname");
    }

    private By lastNameField() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input#field-lastname");
    }

    private By emailField() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input#field-email");
    }

    private By passwordField() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input#field-password");
    }

    private By newPasswordField() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input#field-new_password");
    }

    private By birthDateField() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input#field-birthday");
    }

    private By termsAndConditionsCheckbox() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input[name='psgdpr']");
    }

    private By saveBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "button[type='submit']");
    }


    // Actions
    public void saveChanges() {
        enterPassword(TestConstants.TEST_PASSWORD);
        scrollToElementCenter(termsAndConditionsCheckbox());
        agreeTermsConditions();
        clickSaveBtn();
    }

    public void enterFirstName(String firstName) {
        waitUntilElementIsVisible(firstNameField());
        getDriver().findElement(firstNameField()).clear();
        getDriver().findElement(firstNameField()).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        waitUntilElementIsVisible(lastNameField());
        getDriver().findElement(lastNameField()).clear();
        getDriver().findElement(lastNameField()).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        waitUntilElementIsVisible(emailField());
        getDriver().findElement(emailField()).clear();
        getDriver().findElement(emailField()).sendKeys(email);
    }

    public void enterPassword(String password) {
        waitUntilElementIsVisible(passwordField());
        getDriver().findElement(passwordField()).clear();
        getDriver().findElement(passwordField()).sendKeys(password);
    }

    public void agreeTermsConditions() {
        getDriver().findElement(termsAndConditionsCheckbox()).click();
    }

    public void clickSaveBtn() {
        waitUntilElementIsClickable(saveBtn());
        getDriver().findElement(saveBtn()).click();
    }
}
