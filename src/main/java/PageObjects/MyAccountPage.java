package PageObjects;

import Utilities.BaseClass;
import Utilities.LocatorFactory;
import org.openqa.selenium.By;

import static Utilities.LocatorFactory.LocatorType.CSS_SELECTOR;

public class MyAccountPage extends BaseClass {

    // Elements
    public By informationBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "#identity-link");
    }

    private By addFirstAddressBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "#address-link");
    }

    private By orderHistoryBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "#history-link");
    }

    private By creditSlipsBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "#order-slips-link");
    }

    private By vouchersBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "#discounts-link");
    }

    private By myWishlistsBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "#wishlist-link");
    }

    private By gdprBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "#psgdpr-link");
    }

    private By myAlertsBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "#emailsalerts");
    }


    // Actions
    public void clickInformationBtn() {
        waitUntilElementIsClickable(informationBtn());
        getDriver().findElement(informationBtn()).click();
    }

    public void clickOrderHistoryBtn() {
        waitUntilElementIsClickable(orderHistoryBtn());
        getDriver().findElement(orderHistoryBtn()).click();
    }
}
