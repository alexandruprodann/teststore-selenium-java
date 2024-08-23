package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {

    // Constructor
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // Elements
    private By sizeSelectorBy() {
        return By.cssSelector("#group_1");
    }

    private By quantityIncreaseBtnBy() {
        return By.cssSelector(".bootstrap-touchspin-up");
    }

    private By quantityDecreaseBtnBy() {
        return By.cssSelector(".bootstrap-touchspin-up");
    }

    private By quantityInputBy() {
        return By.cssSelector("input#quantity_wanted");
    }

    private By sizeLabelBy() {
        return By.cssSelector("div:nth-of-type(1) > .control-label");
    }

    private By addToCartBtnBy() {
        return By.cssSelector(".add-to-cart");
    }

    private By homeLinkBy() {
        return By.linkText("Home");
    }

    // Modal buttons
    private By proceedToCheckoutBtnBy() {
        return By.cssSelector(".modal-body .btn.btn-primary");
    }

    private By continueShoppingBtnBy() {
        return By.cssSelector(".modal-body .btn.btn-secondary");
    }

    /*
     *
     * Actions
     *
     * */
    public void selectSize(String size) {
        waitUntilElementIsClickable(sizeSelectorBy());
        Select select = new Select(driver.findElement(sizeSelectorBy()));
        select.selectByVisibleText(size);
        waitForElementToHaveText(sizeLabelBy(), size);
    }

    public void increaseQuantity(int quantity) {
        for (int i = 0; i < quantity; i++) {
            waitUntilElementIsClickable(quantityIncreaseBtnBy());
            driver.findElement(quantityIncreaseBtnBy()).click();
        }
    }

    public void setQuantity(String quantity) {
        waitUntilElementIsVisible(quantityInputBy());
        WebElement quantityInput = driver.findElement(quantityInputBy());
        quantityInput.click();
        quantityInput.sendKeys(Keys.BACK_SPACE);
        quantityInput.sendKeys(quantity);
    }

    public void addItemToCart() {
        waitUntilElementIsClickable(addToCartBtnBy());
        driver.findElement(addToCartBtnBy()).click();
    }

    public void proceedToCart() {
        waitUntilElementIsVisible(proceedToCheckoutBtnBy());
        driver.findElement(proceedToCheckoutBtnBy()).click();
    }

    public void clickContinueShoppingBtn() {
        waitUntilElementIsVisible(continueShoppingBtnBy());
        driver.findElement(continueShoppingBtnBy()).click();
    }

    public void clickHomeLink() {
        waitUntilElementIsClickable(homeLinkBy());
        driver.findElement(homeLinkBy()).click();
    }
 }
