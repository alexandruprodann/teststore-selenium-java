package PageObjects;

import Utilities.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OrderFormPage extends BasePage {

    public OrderFormPage(WebDriver driver) {
        super(driver);
    }

    // Locate elements using @FindBy annotation
    @FindBy(css = "[for='field-id_gender-1']")
    private WebElement maleGender;

    @FindBy(css = "[for='field-id_gender-2']")
    private WebElement femaleGender;

    @FindBy(css = "input#field-firstname")
    private WebElement firstNameField;

    @FindBy(css = "input#field-lastname")
    private WebElement lastNameField;

    @FindBy(css = "input#field-email")
    private WebElement emailField;

    @FindBy(css = "input[name='psgdpr']")
    private WebElement termsConditionsCheckbox;

    @FindBy(xpath = "//form[@id='customer-form']//button[@name='continue']")
    private WebElement continueBtn;

    @FindBy(css = "input[name='address1']")
    private WebElement addressField;

    @FindBy(css = "input#field-city")
    private WebElement cityField;

    @FindBy(css = "select#field-id_state")
    private WebElement stateSelector;

    @FindBy(css = "input#field-postcode")
    private WebElement postalCodeField;

    @FindBy(css = "button[name='confirm-addresses']")
    private WebElement confirmAddressBtn;

    @FindBy(css = "[data-module-name='ps_checkpayment']")
    private WebElement payByCheck;

    @FindBy(xpath = "//input[@id='conditions_to_approve[terms-and-conditions]']")
    private WebElement tosFinal;

    @FindBy (css = ".btn-primary.center-block")
    private WebElement placeOrderBtn;

    @FindBy(css = "[name='confirmDeliveryOption']")
    private WebElement confirmShippingMethodBtn;



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
        waitForVisibility(maleGender);
        maleGender.click();
    }

    public void enterFirstName(String name) {
        waitForVisibility(firstNameField);
        firstNameField.sendKeys(name);
    }

    public void enterLastName(String name) {
        waitForVisibility(lastNameField);
        lastNameField.sendKeys(name);
    }

    public void enterEmail(String email) {
        waitForVisibility(emailField);
        emailField.sendKeys(email);
    }

    public void agreeTermsConditions() {
        termsConditionsCheckbox.click();
    }


    /*
    * Address Fields
    * */
    public void enterAddress(String address) {
        waitForVisibility(addressField);
        addressField.sendKeys(address);
    }

    public void enterCity(String city) {
        waitForVisibility(cityField);
        cityField.sendKeys(city);
    }

    public void enterPostCode(String postcode) {
        waitForVisibility(postalCodeField);
        postalCodeField.sendKeys(postcode);
    }

    public void selectRandomState() {
        waitForClickable(stateSelector);
        Select select = new Select(stateSelector);
        int numberOfOptions = select.getOptions().size();
        int randomIndex = random.nextInt(numberOfOptions);
        select.selectByIndex(randomIndex);
    }


    /*
    * Last step fields
    * */
    public void selectPayByCheck() {
        payByCheck.click();
    }

    public void agreeTOS() {
        tosFinal.click();
    }

    public void clickPlaceOrderBtn() {
        waitForClickable(placeOrderBtn);
        placeOrderBtn.click();
    }


    /*
    * Continue Buttons
    * */
    // Continue Button - Personal Details
    public void clickContinueBtn() {
        waitForClickable(continueBtn);
        continueBtn.click();
    }

    // Continue Button - Address
    public void clickContinueBtnAddresses() {
        waitForClickable(confirmAddressBtn);
        confirmAddressBtn.click();
    }

    // Continue Button - Shipping
    public void clickContinueBtnShipping() {
        waitForClickable(confirmShippingMethodBtn);
        confirmShippingMethodBtn.click();
    }
}
