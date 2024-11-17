package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class ShoppingCartPage extends BaseClass {

    // Elements
    private By proceedToCheckoutBtn() {
        return By.cssSelector(".js-cart-detailed-actions .btn-primary");
    }

    private By removeFromCartBtn() {
        return By.cssSelector(".remove-from-cart");
    }

    private By promoCodeLink() {
        return By.cssSelector(".promo-code-button .collapse-button");
    }

    private By promoCodeInput() {
        return By.cssSelector("input[name='discount_name']");
    }

    private By promoCodeLabel() {
        return By.cssSelector(".promo-name .label");
    }

    public By itemsInCartSpan() {
        return By.cssSelector(".js-subtotal");
    }

    private By cartItemTitles() {
        return By.cssSelector("[data-id_customization]");
    }

    private By subTotalProductsValue() {
        return By.cssSelector("#cart-subtotal-products .value");
    }

    private By discountValue() {
        return By.cssSelector("#cart-subtotal-discount .value");
    }

    private By shippingPrice() {
        return By.cssSelector("#cart-subtotal-shipping .value");
    }

    private By cartTotal() {
        return By.cssSelector(".cart-summary-line.cart-total .value");
    }

    private By quantityInput() {
        return By.cssSelector("input.js-cart-line-product-quantity");
    }


    /*
     *
     * Actions
     *
     * */
    public void addPromoCode(String promoCode) {
        waitUntilElementIsClickable(promoCodeLink());
        getDriver().findElement(promoCodeLink()).click();

        waitUntilElementIsVisible(promoCodeInput());
        WebElement promoCodeInput = getDriver().findElement(promoCodeInput());
        promoCodeInput.sendKeys(promoCode);
        pressEnter(promoCodeInput);
        waitForElementToHaveText(promoCodeLabel(), promoCode);
    }

    public void proceedToCheckout() {
        waitUntilElementIsClickable(proceedToCheckoutBtn());
        getDriver().findElement(proceedToCheckoutBtn()).click();
    }

    public int getCartItemCount() {
        waitUntilElementIsVisible(itemsInCartSpan());
        String itemText = getDriver().findElement(itemsInCartSpan()).getText();
        String numberOnly = itemText.replaceAll("[^0-9]", "");
        return Integer.parseInt(numberOnly);
    }

    public void removeItemsFromCart(int numberOfItems) {
        for (int i = 0; i <= numberOfItems; i++) {
            waitUntilElementIsClickable(removeFromCartBtn());
            getDriver().findElement(removeFromCartBtn()).click();
        }
        waitForElementToHaveText(itemsInCartSpan(), String.valueOf((getCartItemCount() - numberOfItems)));
    }

    public int getItemListSize() {
        return getDriver().findElements(cartItemTitles()).size();
    }

    public double getExpectedTotalAfterDiscount(int discountValue) {
        double itemsTotal = getPriceFromElement(subTotalProductsValue());
        double expectedDiscountValue = itemsTotal * (discountValue / 100.0);

        return itemsTotal - expectedDiscountValue + getPriceFromElement(shippingPrice());
    }

    public double getCartTotal() {
        return getPriceFromElement(cartTotal());
    }

    public void setQuantity(String quantity) {
        waitUntilElementIsVisible(quantityInput());
        WebElement quantityInput = getDriver().findElement(quantityInput());
        quantityInput.click();
        quantityInput.sendKeys(Keys.BACK_SPACE);
        quantityInput.sendKeys(quantity);
        quantityInput.sendKeys(Keys.ENTER);
    }

}
