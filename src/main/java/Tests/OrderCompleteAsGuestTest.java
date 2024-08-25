package Tests;

import PageObjects.*;
import Utilities.BaseClass;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class OrderCompleteAsGuestTest extends BaseClass {

    @Test
    public void orderComplete() {

        // Pages
        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        OrderFormPage orderFormPage = new OrderFormPage();
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();


        // Steps
        Reporter.log("Proceed to " + TestConstants.BASE_URL);
        getDriver().get(TestConstants.BASE_URL);

        Reporter.log("Select a random clothing item and size");
        homePage.chooseRandomClothing();
        productPage.selectSize("M");

        Reporter.log("Increase item quantity by any amount");
        productPage.increaseQuantity(4);

        Reporter.log("Add the product to cart and proceed to Shopping Cart");
        productPage.addItemToCart();
        productPage.proceedToCart();

        Reporter.log("Add the '" + TestConstants.PROMOCODE_TWENTY + "' promo code and proceed to checkout");
        shoppingCartPage.addPromoCode(TestConstants.PROMOCODE_TWENTY);
        shoppingCartPage.proceedToCheckout();

        Reporter.log("Enter any personal details");
        orderFormPage.enterPersonalInformation(TestConstants.FIRST_NAME, TestConstants.LAST_NAME);
        orderFormPage.clickContinueBtn();

        Reporter.log("Enter any address");
        orderFormPage.enterCompleteAddress(TestConstants.ADDRESS, TestConstants.CITY, TestConstants.POSTAL_CODE);
        orderFormPage.clickContinueBtnAddresses();

        Reporter.log("Confirm shipping option");
        orderFormPage.clickContinueBtnShipping();

        Reporter.log("Complete the order");
        orderFormPage.selectPayByCheck();
        orderFormPage.agreeTOS();
        orderFormPage.clickPlaceOrderBtn();

        // Wait for the title to be "Order confirmation"
        orderConfirmationPage.waitForTitleToContain("Order confirmation");

        // Assert that the title is exactly "Order confirmation"
        Assert.assertEquals(getDriver().getTitle(), "Order confirmation", "The page title is not 'Order confirmation'" +
                "\nCurrent page title: " + getDriver().getTitle());
    }
}
