package PageObjects;

import Utilities.BaseClass;
import Utilities.TestConstants;
import Utilities.TestUtils;
import org.openqa.selenium.By;

public class SignUpPage extends BaseClass {

    // Elements
    private By signUpFormFieldBy(String name) {
        return By.cssSelector(String.format("[name='%s']", name));
    }

    private By maleGenderBy() {
        return By.cssSelector("input#field-id_gender-1");
    }

    private By tosCheckboxBy() {
        return By.cssSelector("input[name='psgdpr']");
    }

    private By saveBtnBy() {
        return By.cssSelector("button.form-control-submit");
    }

    // Actions
    public void enterSignUpDetails() {
        selectMaleGender();
        enterField("firstname", TestConstants.FIRST_NAME);
        enterField("lastname", TestConstants.LAST_NAME);
        enterField("email", TestUtils.generateRandomEmail());
        enterField("password", TestConstants.TEST_PASSWORD);
        enterField("birthday", TestConstants.BIRTHDAY);
        agreeTOS();
    }

    public void enterField(String name, String text) {
        waitUntilElementIsVisible(signUpFormFieldBy(name));
        getDriver().findElement(signUpFormFieldBy(name)).sendKeys(text);
    }

    public void selectMaleGender() {
        getDriver().findElement(maleGenderBy()).click();
    }

    public void agreeTOS() {
        getDriver().findElement(tosCheckboxBy()).click();
    }

    public void clickSaveBtn() {
        waitUntilElementIsClickable(saveBtnBy());
        getDriver().findElement(saveBtnBy()).click();
    }
}
