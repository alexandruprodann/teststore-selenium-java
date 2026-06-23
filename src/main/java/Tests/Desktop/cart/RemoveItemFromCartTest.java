package Tests.Desktop.cart;

import PageObjects.HomePage;
import PageObjects.ProductPage;
import PageObjects.ShoppingCartPage;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class RemoveItemFromCartTest extends BaseClass {

    @Test(groups = {Platform.PC})
    public void removeItemFromCart() {

        // Pages
        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

        // Steps
        Reporter.log("Proceed to Homepage: " + TestConstants.BASE_URL);
        navigateToUrl(TestConstants.BASE_URL);

        Reporter.log("Select two products and add them to the Shopping Cart");
        homePage.clickProductByName(TestConstants.TODAY_MUG);
        productPage.addItemToCart();
        productPage.clickContinueShoppingBtn();
        productPage.clickHomeLink();
        homePage.clickProductByName(TestConstants.HUMMINGBIRD_TSHIRT);
        productPage.addItemToCart();

        Reporter.log("Proceed to Shopping Cart Page and remove 1 item");
        productPage.proceedToCart();

        Reporter.log("Ensure that exactly 2 items are in the Shopping Cart");
        shoppingCartPage.waitForItemListSize(2);
        shoppingCartPage.removeItemsFromCart(1);

        Reporter.log("Ensure that there is only 1 item in the Shopping Cart");
        shoppingCartPage.waitForItemListSize(1);
        Assert.assertEquals(shoppingCartPage.getItemListSize(), 1, "There is more than 1 item in the Shopping Cart!");
    }
}
