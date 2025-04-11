package Tests.Mobile.product;

import PageObjects.HomePage;
import PageObjects.ProductPage;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.List;

public class BreadcrumbNavigationTest extends BaseClass {

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

        Reporter.log("Verify all breadcrumb links are accessible");
        List<String> links = productPage.getBreadcrumbHrefs();

        for (String link : links) {
            navigateToUrl(link);
            Assert.assertFalse(getDriver().getTitle().isEmpty(), "Page title should not be empty for: " + link);
        }
    }
}
