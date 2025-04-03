package Tests.Mobile.user;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyWishlistsPage;
import PageObjects.ProductPage;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static Utilities.TestConstants.PRINTED_SWEATER;

public class AddToWishlistTest extends BaseClass {

    @Test(groups = {Platform.MOBILE})
    public void signUp() {

        // Pages
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        MyWishlistsPage myWishlistsPage = new MyWishlistsPage();


        // Steps
        Reporter.log("Proceed to Homepage: " + TestConstants.BASE_URL);
        navigateToUrl(TestConstants.BASE_URL);

        Reporter.log("Click Sign In button");
        homePage.clickSignIn();

        Reporter.log("Login as (" + TestConstants.TEST_EMAIL + "/" + TestConstants.TEST_PASSWORD + ")");
        loginPage.loginAs(TestConstants.TEST_EMAIL, TestConstants.TEST_PASSWORD);

        Reporter.log("Proceed to Homepage");
        navigateToUrl(TestConstants.BASE_URL);

        Reporter.log("Add " + PRINTED_SWEATER + " to wishlist");
        homePage.clickProductByName(PRINTED_SWEATER);
        productPage.clickAddToWishlist();
        productPage.clickMyWishlistBtn();
        Assert.assertTrue(productPage.isWishlistSuccessAlertVisible(), "Wishlist success alert 'Product added' is not displayed!");

        Reporter.log("Navigate to 'My Wishlists'");
        navigateToUrl(TestConstants.MY_WISHLISTS_URL);

        Reporter.log("Click on 'My Wishlist' link");
        myWishlistsPage.clickMyWishlistLink();

        Reporter.log("Check if " + PRINTED_SWEATER + " is in the wishlist");
        Assert.assertTrue(myWishlistsPage.isElementDisplayed(myWishlistsPage.productTitleWithText(PRINTED_SWEATER)), PRINTED_SWEATER + " is not displayed in the wishlist!");

        Reporter.log("Remove the " + PRINTED_SWEATER + " from wishlist");
        myWishlistsPage.removeProductFromWishlist(PRINTED_SWEATER);
    }
}
