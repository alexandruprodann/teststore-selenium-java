package Tests.Mobile;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SignUpPage;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SignupTest extends BaseClass {

    @Test(groups = {Platform.MOBILE})
    public void signUp() {

        // Pages
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        SignUpPage signUpPage = new SignUpPage();


        // Steps
        Reporter.log("Proceed to Homepage: " + TestConstants.BASE_URL);
        navigateToUrl(TestConstants.BASE_URL);

        Reporter.log("Click Sign In button (person icon in the header)");
        homePage.clickSignIn();

        Reporter.log("Click 'No account? Create one here' link");
        loginPage.clickCreateAccountLink();

        Reporter.log("Fill in the Sign Up form");
        signUpPage.enterSignUpDetails();
        signUpPage.clickSaveBtn();

        Reporter.log("Observe user is redirected to Homepage after signup");
        Assert.assertTrue(waitForUrlToContainBool(TestConstants.BASE_URL), "Sign up was not successful (not redirected to the homepage). " +
                "\nCurrent URL is: " + getDriver().getCurrentUrl());
    }
}
