package Tests.Mobile;

import PageObjects.HomePage;
import PageObjects.ProductPage;
import PageObjects.ShoppingCartPage;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class UpdateItemQuantityTest extends BaseClass {

    @Test(groups = {Platform.MOBILE})
    public void updateItemQuantity() {

        int increaseValue = 2;
        String setValue = "5";
        String expectedTotalValue = String.valueOf(increaseValue + 1);

        // Pages
        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

        // Steps
        Reporter.log("Proceed to " + TestConstants.BASE_URL);
        getDriver().get(TestConstants.BASE_URL);

        Reporter.log("Select a random clothing item and size");
        homePage.openHamburgerMenu();
        homePage.chooseRandomClothing();
        productPage.selectSize("L");

        Reporter.log("Add the product to cart and proceed to Shopping Cart page");
        productPage.addItemToCart();
        productPage.proceedToCart();

        Reporter.log("Increase the item quantity in the cart by " + increaseValue + " units using the up arrow button");
        productPage.increaseQuantity(increaseValue);

        Reporter.log("Verify that the quantity of the item in the shopping cart is updated correctly");
        try {
            waitForElementToHaveText(shoppingCartPage.itemsInCartSpan(), expectedTotalValue);
        } catch (TimeoutException exception) {
            Assert.fail("Item quantity was not updated. " +
                    "\nExpected: " + expectedTotalValue +
                    "\nFound: " + shoppingCartPage.getCartItemCount());
        }

        Reporter.log("Set the quantity to " + setValue + " units using the input box directly");
        shoppingCartPage.setQuantity(setValue);
        try {
            waitForElementToHaveText(shoppingCartPage.itemsInCartSpan(), setValue);
        } catch (TimeoutException exception) {
            Assert.fail("Item quantity was not updated. " +
                    "\nExpected: " + setValue +
                    "\nFound: " + shoppingCartPage.getCartItemCount());
        }


    }
}
