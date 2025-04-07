package PageObjects;

import Utilities.BaseClass;
import Utilities.TestConstants;
import org.openqa.selenium.By;

public class SignUpPage extends BaseClass {

    // Elements
    private By signUpFormField(String name) {
        return By.cssSelector(String.format("[name='%s']", name));
    }

    private By maleGender() {
        return By.cssSelector("input#field-id_gender-1");
    }

    private By tosCheckbox() {
        return By.cssSelector("input[name='psgdpr']");
    }

    private By saveBtn() {
        return By.cssSelector("button.form-control-submit");
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
