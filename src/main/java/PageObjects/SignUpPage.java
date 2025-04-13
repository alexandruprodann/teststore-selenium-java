package PageObjects;

import Utilities.BaseClass;
import Utilities.LocatorFactory;
import Utilities.TestConstants;
import org.openqa.selenium.By;

import static Utilities.LocatorFactory.LocatorType.CSS_SELECTOR;

public class SignUpPage extends BaseClass {

    // Elements
    private By signUpFormField(String name) {
        return LocatorFactory.createLocator(CSS_SELECTOR, String.format("[name='%s']", name));
    }

    private By maleGender() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input#field-id_gender-1");
    }

    private By tosCheckbox() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input[name='psgdpr']");
    }

    private By saveBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "button.form-control-submit");
    }


    // Actions
    public void enterSignUpDetails() {
        selectMaleGender();
        enterField("firstname", TestConstants.FIRST_NAME);
        enterField("lastname", TestConstants.LAST_NAME);
        enterField("email", generateRandomEmail());
        enterField("password", generateRandomPassword());
        enterField("birthday", TestConstants.BIRTHDAY);
        agreeTOS();
    }

    public void enterField(String name, String text) {
        waitUntilElementIsVisible(signUpFormField(name));
        getDriver().findElement(signUpFormField(name)).sendKeys(text);
    }

    public void selectMaleGender() {
        getDriver().findElement(maleGender()).click();
    }

    public void agreeTOS() {
        getDriver().findElement(tosCheckbox()).click();
    }

    public void clickSaveBtn() {
        waitUntilElementIsClickable(saveBtn());
        getDriver().findElement(saveBtn()).click();
    }
}
