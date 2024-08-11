package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    // Constructor
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    // Locate elements using @FindBy annotation
    @FindBy(css = ".js-cart-detailed-actions .btn-primary")
    private WebElement proceedToCheckoutBtn;

    @FindBy(css = ".remove-from-cart")
    private WebElement removeFromCartBtn;

    @FindBy(css = ".promo-code-button .collapse-button")
    private WebElement promoCodeLink;

    @FindBy(css = "input[name='discount_name']")
    private WebElement promoCodeInput;

    @FindBy(css = ".promo-name .label")
    private WebElement promoCodeLabel;

    @FindBy(css = ".js-subtotal")
    private WebElement itemsInCartSpan;

    @FindBy(css = "[data-id_customization]")
    private List<WebElement> cartItemTitles;


    /*
     *
     * Actions
     *
     * */
    public void addPromoCode(String promoCode) {
        waitForClickable(promoCodeLink);
        promoCodeLink.click();
        waitForVisibility(promoCodeInput);
        promoCodeInput.sendKeys(promoCode);
        pressEnter(promoCodeInput);
        waitForElementToHaveText(promoCodeLabel, promoCode);
    }

    public void proceedToCheckout() {
        waitForClickable(proceedToCheckoutBtn);
        proceedToCheckoutBtn.click();
    }

    public int getCartItemCount() {
        waitForVisibility(itemsInCartSpan);
        String itemText = itemsInCartSpan.getText();
        String numberOnly = itemText.replaceAll("[^0-9]", "");
        return Integer.parseInt(numberOnly);
    }


    public void removeItemsFromCart(int numberOfItems) {
        for (int i = 0; i <= numberOfItems; i++) {
            waitForClickable(removeFromCartBtn);
            removeFromCartBtn.click();
        }
        waitForElementToHaveText(itemsInCartSpan, String.valueOf((getCartItemCount() - numberOfItems)));
    }

    public int getItemListSize() {
        return cartItemTitles.size();
    }

}
