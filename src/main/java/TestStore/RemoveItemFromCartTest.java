package TestStore;

import PageObjects.HomePage;
import PageObjects.ProductPage;
import PageObjects.ShoppingCartPage;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveItemFromCartTest extends BaseTest {

    @Test
    public void removeItemFromCart() throws InterruptedException {
        driver.get(TestConstants.BASE_URL);

        // Create instances of pages
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        // Select two random products and add them to cart
        addRandomProductToCart(homePage, productPage);
        continueShoppingAndAddAnotherProduct(homePage, productPage);

        // Proceed to Shopping Cart Page and remove 1 item
        productPage.proceedToCart();

        // Ensure at least two items are in the cart
        if (shoppingCartPage.getItemListSize() < 2) {
            driver.get(TestConstants.BASE_URL);
            addRandomProductToCart(homePage, productPage);
        }
        shoppingCartPage.removeItemsFromCart(1);

        // Assert that there is only 1 item in the cart
        Assert.assertEquals(shoppingCartPage.getCartItemCount(), 1);

        Thread.sleep(4000);
    }



    // Method to add a random product to cart
    private void addRandomProductToCart(HomePage homePage, ProductPage productPage) {
        homePage.chooseRandomProduct();
        productPage.addItemToCart();
    }

    // Method to continue shopping and add another random product to cart
    private void continueShoppingAndAddAnotherProduct(HomePage homePage, ProductPage productPage) {
        productPage.clickContinueShoppingBtn();
        productPage.clickHomeLink();
        addRandomProductToCart(homePage, productPage);
    }
}
