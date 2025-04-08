package Tests.Mobile.product;

import PageObjects.HomePage;
import PageObjects.ProductPage;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ProductDetailsTest extends BaseClass {

    @Test(groups = {Platform.MOBILE})
    public void productDetails() {

        // Pages
        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();

        // Steps
        Reporter.log("Proceed to " + TestConstants.BASE_URL);
        navigateToUrl(TestConstants.BASE_URL);

        Reporter.log("Choose a random product");
        homePage.chooseRandomProduct();

        Reporter.log("Check if the breadcrumb is displayed");
        Assert.assertTrue(isElementDisplayed(productPage.breadCrumb()), "Breadcrumb is not displayed!");

        Reporter.log("Check if the product title is displayed");
        Assert.assertTrue(isElementDisplayed(productPage.productTitle()), "Product title is not displayed!");

        Reporter.log("Check if the product price is displayed");
        Assert.assertTrue(isElementDisplayed(productPage.productPrice()), "Product price is not displayed!");

        Reporter.log("Check if the product image is displayed");
        Assert.assertTrue(isElementDisplayed(productPage.productImage()), "Product image is not displayed!");

        Reporter.log("Check if the short description is displayed");
        Assert.assertTrue(isElementDisplayed(productPage.productShortDescription()), "Short description is not displayed!");

        Reporter.log("Check if the 'Add to cart' button is displayed");
        Assert.assertTrue(isElementDisplayed(productPage.addToCartBtn()), "'Add to cart' button is not displayed!");

        Reporter.log("Check if the long description is displayed");
        Assert.assertTrue(isElementDisplayed(productPage.productLongDescription()), "Long description is not displayed!");
    }
}
