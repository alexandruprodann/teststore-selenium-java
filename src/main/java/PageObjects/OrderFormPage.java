package PageObjects;

import Utilities.BaseClass;
import Utilities.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class OrderFormPage extends BaseClass {

    // Locate elements using @FindBy annotation
    private By maleGender() {
        return By.cssSelector("[for='field-id_gender-1']");
    }

    private By firstNameField() {
        return By.cssSelector("input#field-firstname");
    }

    private By lastNameField() {
        return By.cssSelector("input#field-lastname");
    }

    private By emailField() {
        return By.cssSelector("input#field-email");
    }

    private By termsConditionsCheckbox() {
        return By.cssSelector("input[name='psgdpr']");
    }

    private By continueBtn() {
        return By.xpath("//form[@id='customer-form']//button[@name='continue']");
    }

    private By addressField() {
        return By.cssSelector("input[name='address1']");
    }

    private By cityField() {
        return By.cssSelector("input#field-city");
    }

    private By stateSelector() {
        return By.cssSelector("select#field-id_state");
    }

    private By postCodeField() {
        return By.cssSelector("input#field-postcode");
    }

    private By confirmAddressBtn() {
        return By.cssSelector("button[name='confirm-addresses']");
    }

    private By payByCheck() {
        return By.cssSelector("[data-module-name='ps_checkpayment']");
    }

    private By tosFinal() {
        return By.xpath("//input[@id='conditions_to_approve[terms-and-conditions]']");
    }

    private By placeOrderBtn() {
        return By.cssSelector(".btn-primary.center-block");
    }

    private By confirmShippingMethodBtn() {
        return By.cssSelector("[name='confirmDeliveryOption']");
    }


    /*
    *
    * Actions
    *
    * */

    public void enterPersonalInformation(String f_name, String l_name) {
        setGenderMale();
        enterFirstName(f_name);
        enterLastName(l_name);
        enterEmail(TestUtils.generateRandomEmail());
        agreeTermsConditions();
    }

    public void enterCompleteAddress(String address, String city, String postcode) {
        enterAddress(address);
        enterCity(city);
        enterPostCode(postcode);
        selectRandomState();
    }


    /*
    * Personal Details
    * */
    public void setGenderMale() {
        waitUntilElementIsVisible(maleGender());
        getDriver().findElement(maleGender()).click();
    }

    public void enterFirstName(String name) {
        waitUntilElementIsVisible(firstNameField());
        getDriver().findElement(firstNameField()).sendKeys(name);
    }

    public void enterLastName(String name) {
        waitUntilElementIsVisible(lastNameField());
        getDriver().findElement(lastNameField()).sendKeys(name);
    }

    public void enterEmail(String email) {
        waitUntilElementIsVisible(emailField());
        getDriver().findElement(emailField()).sendKeys(email);
    }

    public void agreeTermsConditions() {
        getDriver().findElement(termsConditionsCheckbox()).click();
    }


    /*
    * Address Fields
    * */
    public void enterAddress(String address) {
        waitUntilElementIsVisible(addressField());
        getDriver().findElement(addressField()).sendKeys(address);
    }

    public void enterCity(String city) {
        waitUntilElementIsVisible(cityField());
        getDriver().findElement(cityField()).sendKeys(city);
    }

    public void enterPostCode(String postcode) {
        waitUntilElementIsVisible(postCodeField());
        getDriver().findElement(postCodeField()).sendKeys(postcode);
    }

    public void selectRandomState() {
        waitUntilElementIsClickable(stateSelector());
        Select select = new Select(getDriver().findElement(stateSelector()));
        int numberOfOptions = select.getOptions().size();
        int randomIndex = random.nextInt(numberOfOptions);
        select.selectByIndex(randomIndex);
    }


    /*
    * Last step fields
    * */
    public void selectPayByCheck() {
        getDriver().findElement(payByCheck()).click();
    }

    public void agreeTOS() {
        getDriver().findElement(tosFinal()).click();
    }

    public void clickPlaceOrderBtn() {
        waitUntilElementIsClickable(placeOrderBtn());
        getDriver().findElement(placeOrderBtn()).click();
    }


    /*
    * Continue Buttons
    * */
    // Continue Button - Personal Details
    public void clickContinueBtn() {
        waitUntilElementIsClickable(continueBtn());
        getDriver().findElement(continueBtn()).click();
    }

    // Continue Button - Address
    public void clickContinueBtnAddresses() {
        waitUntilElementIsClickable(confirmAddressBtn());
        getDriver().findElement(confirmAddressBtn()).click();
    }

    // Continue Button - Shipping
    public void clickContinueBtnShipping() {
        waitUntilElementIsClickable(confirmShippingMethodBtn());
        getDriver().findElement(confirmShippingMethodBtn()).click();
    }
}
