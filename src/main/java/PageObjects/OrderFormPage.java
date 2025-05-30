package PageObjects;

import Utilities.BaseClass;
import Utilities.LocatorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static Utilities.LocatorFactory.LocatorType.CSS_SELECTOR;
import static Utilities.LocatorFactory.LocatorType.XPATH;

public class OrderFormPage extends BaseClass {

    // Elements
    private By maleGender() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "[for='field-id_gender-1']");
    }

    private By firstNameField() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input#field-firstname");
    }

    private By lastNameField() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input#field-lastname");
    }

    private By emailField() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input#field-email");
    }

    private By termsConditionsCheckbox() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input[name='psgdpr']");
    }

    private By continueBtn() {
        return LocatorFactory.createLocator(XPATH, "//form[@id='customer-form']//button[@name='continue']");
    }

    private By addressField() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input[name='address1']");
    }

    private By cityField() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input#field-city");
    }

    private By stateSelector() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "select#field-id_state");
    }

    private By postCodeField() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input#field-postcode");
    }

    private By confirmAddressBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "button[name='confirm-addresses']");
    }

    private By payByCheck() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "#payment-option-2-container>label");
    }

    private By tosFinal() {
        return LocatorFactory.createLocator(XPATH, "//input[@id='conditions_to_approve[terms-and-conditions]']");
    }

    private By placeOrderBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".btn-primary.center-block");
    }

    private By confirmShippingMethodBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "[name='confirmDeliveryOption']");
    }


    // Actions
    public void enterPersonalInformation(String firstName, String lastName) {
        setGenderMale();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(generateRandomEmail());
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
        int randomIndex = random.nextInt(numberOfOptions - 1);
        select.selectByIndex(randomIndex);
    }


    /*
    * Last step fields
    * */
    public void selectPayByCheck() {
        scrollToElementCenter(payByCheck());
        waitUntilElementIsClickable(payByCheck());
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
        scrollToElementCenter(confirmShippingMethodBtn());
        waitUntilElementIsClickable(confirmShippingMethodBtn());
        getDriver().findElement(confirmShippingMethodBtn()).click();
    }
}
