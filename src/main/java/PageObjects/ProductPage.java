package PageObjects;

import Utilities.BaseClass;
import Utilities.LocatorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static Utilities.LocatorFactory.LocatorType.*;

public class ProductPage extends BaseClass {

    // Elements
    public By productTitle() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".h1");
    }

    public By productPrice() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".current-price");
    }

    public By productImage() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".product-cover");
    }

    public By productShortDescription() {
        return LocatorFactory.createLocator(XPATH, "(//div[@class='product-description']//p)[1]");
    }

    public By productLongDescription() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "#description");
    }

    private By sizeSelector() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "#group_1");
    }

    private By quantityIncreaseBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".bootstrap-touchspin-up");
    }

    private By quantityDecreaseBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".bootstrap-touchspin-down");
    }

    private By quantityInput() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "input#quantity_wanted");
    }

    private By sizeLabel() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "div:nth-of-type(1) > .control-label");
    }

    public By addToCartBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".add-to-cart");
    }

    private By homeLink() {
        return LocatorFactory.createLocator(LINK_TEXT, "Home");
    }

    private By addToWishlist() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".wishlist-button-add.wishlist-button-product");
    }

    public By wishlistSuccessAlert() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".wishlist-toast.success");
    }

    public By breadCrumb() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".breadcrumb");
    }

    private By breadCrumbLinks() {
        return LocatorFactory.createLocator(XPATH, "//nav[@class='breadcrumb']//li//a");
    }

    // Modal buttons
    private By proceedToCheckoutBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".modal-body .btn.btn-primary");
    }

    private By continueShoppingBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".modal-body .btn.btn-secondary");
    }

    private By myWishlistBtn() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".wishlist-list-item");
    }


    // Actions
    public void selectSize(String size) {
        waitUntilElementIsClickable(sizeSelector());
        Select select = new Select(getDriver().findElement(sizeSelector()));
        select.selectByVisibleText(size);
        waitForElementToHaveText(sizeLabel(), size);
    }

    public void increaseQuantityBy(int quantity) {
        for (int i = 0; i < quantity; i++) {
            waitUntilElementIsClickable(quantityIncreaseBtn());
            getDriver().findElement(quantityIncreaseBtn()).click();
        }
    }

    public void setQuantity(String quantity) {
        waitUntilElementIsVisible(quantityInput());
        WebElement quantityInput = getDriver().findElement(quantityInput());
        quantityInput.click();
        quantityInput.sendKeys(Keys.BACK_SPACE);
        quantityInput.sendKeys(quantity);
    }

    public void addItemToCart() {
        waitUntilElementIsClickable(addToCartBtn());
        getDriver().findElement(addToCartBtn()).click();
    }

    public void proceedToCart() {
        waitUntilElementIsVisible(proceedToCheckoutBtn());
        getDriver().findElement(proceedToCheckoutBtn()).click();
    }

    public void clickContinueShoppingBtn() {
        waitUntilElementIsVisible(continueShoppingBtn());
        getDriver().findElement(continueShoppingBtn()).click();
    }

    public void clickHomeLink() {
        waitUntilElementIsClickable(homeLink());
        getDriver().findElement(homeLink()).click();
    }

    public void clickAddToWishlist() {
        waitUntilElementIsClickable(addToWishlist());
        getDriver().findElement(addToWishlist()).click();
    }

    public void clickMyWishlistBtn() {
        waitUntilElementIsClickable(myWishlistBtn());
        getDriver().findElement(myWishlistBtn()).click();
    }

    public List<String> getBreadcrumbHrefs() {
        List<WebElement> breadCrumbLinks = getDriver().findElements(breadCrumbLinks());
        List<String> hrefs = new ArrayList<>();

        for (WebElement link : breadCrumbLinks) {
            hrefs.add(link.getDomAttribute("href"));
        }

        return hrefs;
    }
 }
