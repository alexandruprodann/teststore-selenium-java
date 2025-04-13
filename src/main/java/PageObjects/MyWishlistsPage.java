package PageObjects;

import Utilities.BaseClass;
import Utilities.LocatorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Utilities.LocatorFactory.LocatorType.CSS_SELECTOR;
import static Utilities.LocatorFactory.LocatorType.XPATH;


public class MyWishlistsPage extends BaseClass {

    // Elements
    private By myWishlistLink() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".wishlist-list-item-link");
    }

    private By productTitle() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".wishlist-product-title");
    }

    public By productTitleWithText(String title) {
        return LocatorFactory.createLocator(XPATH, "//p[normalize-space()='" + title + "']");
    }

    private By removeProductBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".wishlist-button-add");
    }

    private By confirmRemoveModalBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".modal-footer .btn-primary");
    }

    private By wishlistItem() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "li.wishlist-products-item");
    }


    // Actions
    public void clickMyWishlistLink() {
        waitUntilElementIsClickable(myWishlistLink());
        getDriver().findElement(myWishlistLink()).click();
    }

    public void removeProductFromWishlist(String productName) {
        List<WebElement> wishlistItems = getDriver().findElements(wishlistItem());

        for (WebElement item : wishlistItems) {
            String productTitleText = item.findElement(productTitle()).getText();
            WebElement removeButton = item.findElement(removeProductBtn());

            if (productTitleText.equals(productName)) {
                removeButton.click();
                break;
            }
        }

        waitUntilElementIsVisible(confirmRemoveModalBtn());
        getDriver().findElement(confirmRemoveModalBtn()).click();
    }


}
