package Tests.Desktop.user;

import PageObjects.*;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class ProfileUpdateTest extends BaseClass {

    @Test(groups = {Platform.PC})
    public void profileUpdate() {

        String randomString = generateRandomString();

        // Pages
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        MyAccountPage myAccountPage = new MyAccountPage();
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();


        // Steps
        Reporter.log("Proceed to Homepage: " + TestConstants.BASE_URL);
        navigateToUrl(TestConstants.BASE_URL);

        Reporter.log("Click Sign In button");
        homePage.clickSignIn();

        Reporter.log("Login as (" + TestConstants.TEST_EMAIL + "/" + TestConstants.TEST_PASSWORD + ")");
        loginPage.loginAs(TestConstants.TEST_EMAIL, TestConstants.TEST_PASSWORD);

        Reporter.log("Proceed to My Account -> Information");
        homePage.clickMyAccountLink();
        myAccountPage.clickInformationBtn();

        Reporter.log("Change the First Name to " + randomString);
        personalDetailsPage.enterFirstName(randomString);

        Reporter.log("Save the changes");
        personalDetailsPage.saveChanges();

        Reporter.log("Check if the new First Name was saved successfully");
        String newFirstName = getAttributeFromElement(personalDetailsPage.firstNameField(), "value");
        Assert.assertTrue(newFirstName.contains(randomString), "The new First Name was not successfully saved.");
    }
}
