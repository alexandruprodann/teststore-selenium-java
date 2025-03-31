package Tests.Mobile;

import PageObjects.HomePage;
import PageObjects.OrderFormPage;
import PageObjects.ProductPage;
import PageObjects.ShoppingCartPage;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class OrderCompleteAsGuestTest extends BaseClass {

    @Test(groups = {Platform.MOBILE})
    public void orderComplete() {

        // Pages
        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        OrderFormPage orderFormPage = new OrderFormPage();


        // Steps
        Reporter.log("Proceed to " + TestConstants.BASE_URL);
        getDriver().get(TestConstants.BASE_URL);

        Reporter.log("Open Hamburger Menu and click Clothing Link");
        // Clicking Clothing link is done in chooseRandomClothing method
        homePage.openHamburgerMenu();

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


        // Assert that the title is exactly "Order confirmation"
        Assert.assertTrue(waitForTitleToContainBool("Order confirmation"), "The page title is not 'Order confirmation'" +
                "\nCurrent page title: " + getDriver().getTitle());
    }
}
