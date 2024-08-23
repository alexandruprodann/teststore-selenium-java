package TestStore;

import PageObjects.*;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderCompleteAsGuestTest extends BaseTest {

    @Test
    public void orderComplete() {
        driver.get(TestConstants.BASE_URL);

        // Create instances of pages
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        OrderFormPage orderFormPage = new OrderFormPage(driver);
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);

        // Select an item and size
        homePage.chooseRandomClothing();
        productPage.selectSize("M");

        // Increase item quantity
        productPage.increaseQuantity(4);

        // Add the product to cart and proceed to Shopping Cart
        productPage.addItemToCart();
        productPage.proceedToCart();

        // Add a promo code and proceed to checkout
        shoppingCartPage.addPromoCode(TestConstants.PROMOCODE_TWENTY);
        shoppingCartPage.proceedToCheckout();

        // Enter personal details
        orderFormPage.enterPersonalInformation(TestConstants.FIRST_NAME, TestConstants.LAST_NAME);
        orderFormPage.clickContinueBtn();

        // Enter address
        orderFormPage.enterCompleteAddress(TestConstants.ADDRESS, TestConstants.CITY, TestConstants.POSTAL_CODE);
        orderFormPage.clickContinueBtnAddresses();

        // Confirm shipping option
        orderFormPage.clickContinueBtnShipping();

        // Complete the order
        orderFormPage.selectPayByCheck();
        orderFormPage.agreeTOS();
        orderFormPage.clickPlaceOrderBtn();

        // Wait for the title to be "Order confirmation"
        orderConfirmationPage.waitForTitleToContain("Order confirmation");

        // Assert that the title is exactly "Order confirmation"
        Assert.assertEquals(driver.getTitle(), "Order confirmation", "The page title is not 'Order confirmation'" +
                "\nCurrent page title: " + driver.getTitle());
    }
}
