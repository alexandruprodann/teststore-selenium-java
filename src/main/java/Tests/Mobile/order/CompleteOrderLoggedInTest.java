package Tests.Mobile.order;

import PageObjects.*;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CompleteOrderLoggedInTest extends BaseClass {

    @Test(groups = {Platform.MOBILE})
    public void completeOrderLoggedIn() {

        // Pages
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        OrderFormPage orderFormPage = new OrderFormPage();

        // Steps
        Reporter.log("Proceed to " + TestConstants.LOGIN_URL);
        navigateToUrl(TestConstants.LOGIN_URL);

        Reporter.log("Login as (" + TestConstants.TEST_EMAIL + "/" + TestConstants.TEST_PASSWORD + ")");
        loginPage.enterEmail(TestConstants.TEST_EMAIL);
        loginPage.enterPassword(TestConstants.TEST_PASSWORD);
        loginPage.clickLogin();

        Reporter.log("Select a random clothing item and size");
        homePage.chooseRandomClothing();
        productPage.selectSize("M");

        Reporter.log("Increase item quantity by any amount");
        productPage.increaseQuantityBy(4);

        Reporter.log("Add the product to cart and proceed to Shopping Cart");
        productPage.addItemToCart();
        productPage.proceedToCart();

        Reporter.log("Add the '" + TestConstants.PROMOCODE_TWENTY + "' promo code and proceed to checkout");
        shoppingCartPage.addPromoCode(TestConstants.PROMOCODE_TWENTY);
        shoppingCartPage.proceedToCheckout();

        Reporter.log("Observe the address is already saved, click continue button");
        orderFormPage.clickContinueBtnAddresses();

        Reporter.log("Confirm shipping option");
        orderFormPage.clickContinueBtnShipping();

        Reporter.log("Complete the order");
        orderFormPage.selectPayByCheck();
        orderFormPage.agreeTOS();
        orderFormPage.clickPlaceOrderBtn();

        Assert.assertTrue(waitForTitleToContainBool("Order confirmation"), "The page title is not 'Order confirmation'" +
                "\nCurrent page title: " + getDriver().getTitle());
    }
}
