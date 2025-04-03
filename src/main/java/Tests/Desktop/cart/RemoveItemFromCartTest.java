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
        getDriver().get(TestConstants.BASE_URL);

        // Pages
        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();


        // Steps
        Reporter.log("Select two random products and add them to the Shopping Cart");
        homePage.chooseRandomProduct();
        productPage.addItemToCart();
        productPage.clickContinueShoppingBtn();
        productPage.clickHomeLink();
        homePage.chooseRandomProduct();
        productPage.addItemToCart();

        Reporter.log("Proceed to Shopping Cart Page and remove 1 item");
        productPage.proceedToCart();

        // Ensure at least two items are in the cart
        if (shoppingCartPage.getItemListSize() < 2) {
            getDriver().get(TestConstants.BASE_URL);
            homePage.chooseRandomProduct();
            productPage.addItemToCart();
            productPage.proceedToCart();
        }
        shoppingCartPage.removeItemsFromCart(1);

        Reporter.log("Ensure that there is only 1 iem in the Shopping Cart");
        Assert.assertEquals(shoppingCartPage.getCartItemCount(), 1, "There is more than 1 item in the Shopping Cart!");
    }
}
