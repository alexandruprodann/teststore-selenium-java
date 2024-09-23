package Tests.Mobile;

import PageObjects.ContactUsPage;
import PageObjects.HomePage;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ContactFormTest extends BaseClass {


    @Test(groups = {Platform.MOBILE})
    public void contactForm() {

        // Pages
        HomePage homePage = new HomePage();
        ContactUsPage contactUsPage = new ContactUsPage();

        // Steps
        Reporter.log("Proceed to " + TestConstants.BASE_URL);
        navigateToUrl(TestConstants.BASE_URL);

        Reporter.log("Click 'Contact us' link in the Hamburger Menu");
        homePage.openHamburgerMenu();
        homePage.clickContactLink();

        Reporter.log("Complete the 'CONTACT US' form with required information");
        contactUsPage.chooseDropdownOption("Customer service");
        contactUsPage.enterEmailAddress(TestConstants.TEST_EMAIL);
        contactUsPage.enterTestMessage();

        Reporter.log("Click 'Send' button to submit the form");
        contactUsPage.clickSendBtn();

        Reporter.log("Observe the success alert");
        Assert.assertTrue(contactUsPage.isSuccessAlertDisplayed(), "The Success Alert is not displayed! Form was not submitted successfully!");
    }
}
