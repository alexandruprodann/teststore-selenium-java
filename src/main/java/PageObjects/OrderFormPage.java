package PageObjects;

import Utilities.BaseClass;
import Utilities.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class OrderFormPage extends BaseClass {

    // Locate elements using @FindBy annotation
    private By maleGenderBy() {
        return By.cssSelector("[for='field-id_gender-1']");
    }

    private By firstNameFieldBy() {
        return By.cssSelector("input#field-firstname");
    }

    private By lastNameFieldBy() {
        return By.cssSelector("input#field-lastname");
    }

    private By emailFieldBy() {
        return By.cssSelector("input#field-email");
    }

    private By termsConditionsCheckboxBy() {
        return By.cssSelector("input[name='psgdpr']");
    }

    private By continueBtnBy() {
        return By.xpath("//form[@id='customer-form']//button[@name='continue']");
    }

    private By addressFieldBy() {
        return By.cssSelector("input[name='address1']");
    }

    private By cityFieldBy() {
        return By.cssSelector("input#field-city");
    }

    private By stateSelectorBy() {
        return By.cssSelector("select#field-id_state");
    }

    private By postCodeFieldBy() {
        return By.cssSelector("input#field-postcode");
    }

    private By confirmAddressBtnBy() {
        return By.cssSelector("button[name='confirm-addresses']");
    }

    private By payByCheckBy() {
        return By.cssSelector("[data-module-name='ps_checkpayment']");
    }

    private By tosFinalBy() {
        return By.xpath("//input[@id='conditions_to_approve[terms-and-conditions]']");
    }

    private By placeOrderBtnBy() {
        return By.cssSelector(".btn-primary.center-block");
    }

    private By confirmShippingMethodBtnBy() {
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
        waitUntilElementIsVisible(maleGenderBy());
        getDriver().findElement(maleGenderBy()).click();
    }

    public void enterFirstName(String name) {
        waitUntilElementIsVisible(firstNameFieldBy());
        getDriver().findElement(firstNameFieldBy()).sendKeys(name);
    }

    public void enterLastName(String name) {
        waitUntilElementIsVisible(lastNameFieldBy());
        getDriver().findElement(lastNameFieldBy()).sendKeys(name);
    }

    public void enterEmail(String email) {
        waitUntilElementIsVisible(emailFieldBy());
        getDriver().findElement(emailFieldBy()).sendKeys(email);
    }

    public void agreeTermsConditions() {
        getDriver().findElement(termsConditionsCheckboxBy()).click();
    }


    /*
    * Address Fields
    * */
    public void enterAddress(String address) {
        waitUntilElementIsVisible(addressFieldBy());
        getDriver().findElement(addressFieldBy()).sendKeys(address);
    }

    public void enterCity(String city) {
        waitUntilElementIsVisible(cityFieldBy());
        getDriver().findElement(cityFieldBy()).sendKeys(city);
    }

    public void enterPostCode(String postcode) {
        waitUntilElementIsVisible(postCodeFieldBy());
        getDriver().findElement(postCodeFieldBy()).sendKeys(postcode);
    }

    public void selectRandomState() {
        waitUntilElementIsClickable(stateSelectorBy());
        Select select = new Select(getDriver().findElement(stateSelectorBy()));
        int numberOfOptions = select.getOptions().size();
        int randomIndex = random.nextInt(numberOfOptions);
        select.selectByIndex(randomIndex);
    }


    /*
    * Last step fields
    * */
    public void selectPayByCheck() {
        getDriver().findElement(payByCheckBy()).click();
    }

    public void agreeTOS() {
        getDriver().findElement(tosFinalBy()).click();
    }

    public void clickPlaceOrderBtn() {
        waitUntilElementIsClickable(placeOrderBtnBy());
        getDriver().findElement(placeOrderBtnBy()).click();
    }


    /*
    * Continue Buttons
    * */
    // Continue Button - Personal Details
    public void clickContinueBtn() {
        waitUntilElementIsClickable(continueBtnBy());
        getDriver().findElement(continueBtnBy()).click();
    }

    // Continue Button - Address
    public void clickContinueBtnAddresses() {
        waitUntilElementIsClickable(confirmAddressBtnBy());
        getDriver().findElement(confirmAddressBtnBy()).click();
    }

    // Continue Button - Shipping
    public void clickContinueBtnShipping() {
        waitUntilElementIsClickable(confirmShippingMethodBtnBy());
        getDriver().findElement(confirmShippingMethodBtnBy()).click();
    }
}
