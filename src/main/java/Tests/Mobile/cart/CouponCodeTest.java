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

import static Utilities.TestConstants.PROMOCODE_TWENTY;

public class CouponCodeTest extends BaseClass {

    @Test(groups = {Platform.MOBILE})
    public void couponCode() {

        // Pages
        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

        // Steps
        Reporter.log("Proceed to Homepage: " + TestConstants.BASE_URL);
        navigateToUrl(TestConstants.BASE_URL);

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

        Reporter.log("Add the '" + PROMOCODE_TWENTY + "' coupon code");
        shoppingCartPage.addPromoCode(PROMOCODE_TWENTY);

        Reporter.log("Verify that the 20% off discount is applied correctly");
        Assert.assertEquals(Math.round(shoppingCartPage.getCartTotal()), Math.round(shoppingCartPage.getExpectedTotalAfterDiscount(20)),
                "The discount code was not applied correctly!" +
                "\nExpected value: " + shoppingCartPage.getExpectedTotalAfterDiscount(20) +
                "\nActual value: " + shoppingCartPage.getCartTotal());
    }
}
