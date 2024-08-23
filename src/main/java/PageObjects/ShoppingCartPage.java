package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    // Constructor
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    // Elements
    private By proceedToCheckoutBtnBy() {
        return By.cssSelector(".js-cart-detailed-actions .btn-primary");
    }

    private By removeFromCartBtnBy() {
        return By.cssSelector(".remove-from-cart");
    }

    private By promoCodeLinkBy() {
        return By.cssSelector(".promo-code-button .collapse-button");
    }

    private By promoCodeInputBy() {
        return By.cssSelector("input[name='discount_name']");
    }

    private By promoCodeLabelBy() {
        return By.cssSelector(".promo-name .label");
    }

    private By itemsInCartSpanBy() {
        return By.cssSelector(".js-subtotal");
    }

    private By cartItemTitles() {
        return By.cssSelector("[data-id_customization]");
    }

    /*
     *
     * Actions
     *
     * */
    public void addPromoCode(String promoCode) {
        waitUntilElementIsClickable(promoCodeLinkBy());
        driver.findElement(promoCodeLinkBy()).click();

        waitUntilElementIsVisible(promoCodeInputBy());
        WebElement promoCodeInput = driver.findElement(promoCodeInputBy());
        promoCodeInput.sendKeys(promoCode);
        pressEnter(promoCodeInput);
        waitForElementToHaveText(promoCodeLabelBy(), promoCode);
    }

    public void proceedToCheckout() {
        waitUntilElementIsClickable(proceedToCheckoutBtnBy());
        driver.findElement(proceedToCheckoutBtnBy()).click();
    }

    public int getCartItemCount() {
        waitUntilElementIsVisible(itemsInCartSpanBy());
        String itemText = driver.findElement(itemsInCartSpanBy()).getText();
        String numberOnly = itemText.replaceAll("[^0-9]", "");
        return Integer.parseInt(numberOnly);
    }


    public void removeItemsFromCart(int numberOfItems) {
        for (int i = 0; i <= numberOfItems; i++) {
            waitUntilElementIsClickable(removeFromCartBtnBy());
            driver.findElement(removeFromCartBtnBy()).click();
        }
        waitForElementToHaveText(itemsInCartSpanBy(), String.valueOf((getCartItemCount() - numberOfItems)));
    }

    public int getItemListSize() {
        return driver.findElements(cartItemTitles()).size();
    }

}
