package Tests.Mobile.cart;

import PageObjects.HomePage;
import PageObjects.ProductPage;
import PageObjects.ShoppingCartPage;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CartPersistenceTest extends BaseClass {

    @Test(groups = {Platform.MOBILE})
    public void cartPersistence() {

        // Pages
        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

        // Steps
        Reporter.log("Proceed to Homepage: " + TestConstants.BASE_URL);
        navigateToUrl(TestConstants.BASE_URL);

        Reporter.log("Select a random clothing item and size");
        homePage.chooseRandomClothing();
        productPage.selectSize("M");

        Reporter.log("Add the product to cart and proceed to Shopping Cart");
        productPage.addItemToCart();
        productPage.proceedToCart();

        Reporter.log("Observe the clothing item added is present in the Shopping Cart");
        Assert.assertTrue(shoppingCartPage.getCartItemCount() > 0, "No items are present in the Shopping Cart!");

        Reporter.log("Navigate away to Homepage");
        navigateToUrl(TestConstants.BASE_URL);

        Reporter.log("Come back to the Shopping Cart");
        homePage.clickCartLink();

        Reporter.log("Ensure that item added to the cart remained");
        Assert.assertTrue(shoppingCartPage.getCartItemCount() > 0, "No items are present in the Shopping Cart!");
    }
}
