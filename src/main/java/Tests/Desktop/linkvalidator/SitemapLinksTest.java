package Tests.Desktop.linkvalidator;

import PageObjects.SitemapPage;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.List;

public class SitemapLinksTest extends BaseClass {

    @Test(groups = {Platform.PC})
    public void siteMapLinks() {

        // Pages
        SitemapPage sitemapPage = new SitemapPage();

        // Steps
        Reporter.log("Proceed to Sitemap: " + TestConstants.SITEMAP_URL);
        navigateToUrl(TestConstants.SITEMAP_URL);

        Reporter.log("Check if the page has any broken links");
        List<WebElement> links = sitemapPage.getLinkList();
        for (WebElement link : links) {
            String url = link.getDomAttribute("href");
            Assert.assertTrue(isLinkValid(url), "Link is invalid: " + url);
        }
    }
}
