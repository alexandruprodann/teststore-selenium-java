package PageObjects;

import Utilities.BaseClass;
import Utilities.LocatorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.Objects;

import static Utilities.LocatorFactory.LocatorType.CSS_SELECTOR;
import static Utilities.LocatorFactory.LocatorType.XPATH;

public class HomePage extends BaseClass {

    // Elements
    private By productItemsList() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".products > div");
    }

    private By searchBar() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".ui-autocomplete-input");
    }

    private By clothesLink() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "#category-3");
    }

    private By accessoriesLink() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "#category-6");
    }

    private By signInLink() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".user-info a");
    }

    private By cartLink() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".blockcart");
    }

    private By contactUsLink() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "div#contact-link a");
    }

    private By hamburgerMenu() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "#menu-icon");
    }

    public By myAccountLink() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "a[title='View my customer account']");
    }

    private By allProductsLink() {
        return LocatorFactory.createLocator(XPATH, "//a[contains(.,'All products')]");
    }


    // Actions
    public void chooseRandomProduct() {
        List<WebElement> productItemsList = getDriver().findElements(productItemsList());
        int randomIndex = random.nextInt(productItemsList.size());
        WebElement chosenProduct = productItemsList.get(randomIndex);

        String chosenProductTitle = getProductTitle(chosenProduct);

        if (Objects.equals(chosenProductTitle, "Customizable Mug")) {
            chooseRandomProduct();
        }

        chosenProduct.click();
    }

    public void chooseRandomClothing() {
        if (isMobile()) {
            openHamburgerMenu();
        }
        clickClothesLink();
        chooseRandomProduct();
    }

    public void searchFor(String searchText) {
        waitUntilElementIsVisible(searchBar());
        WebElement searchBar = getDriver().findElement(searchBar());
        searchBar.sendKeys(searchText);
        pressEnter(searchBar);
    }

    public void clickSignIn() {
        waitUntilElementIsClickable(signInLink());
        getDriver().findElement(signInLink()).click();
    }

    public void clickAccessoriesLink() {
        waitUntilElementIsClickable(accessoriesLink());
        getDriver().findElement(accessoriesLink()).click();
    }

    public void clickClothesLink() {
        waitUntilElementIsClickable(clothesLink());
        getDriver().findElement(clothesLink()).click();
    }

    public void clickContactLink() {
        waitUntilElementIsClickable(contactUsLink());
        getDriver().findElement(contactUsLink()).click();
    }

    public void clickCartLink() {
        waitUntilElementIsClickable(cartLink());
        getDriver().findElement(cartLink()).click();
    }

    public void openHamburgerMenu() {
        waitUntilElementIsClickable(hamburgerMenu());
        getDriver().findElement(hamburgerMenu()).click();
    }

    public void clickProductByName(String productName) {
        WebElement product = getDriver().findElement(By.xpath("//a[contains(text(),'" + productName + "')]"));
        product.click();
    }

    public void clickMyAccountLink() {
        waitUntilElementIsClickable(myAccountLink());
        getDriver().findElement(myAccountLink()).click();
    }

    public void clickAllProductsLink() {
        waitUntilElementIsClickable(allProductsLink());
        getDriver().findElement(allProductsLink()).click();
    }

    public String getProductTitle(WebElement chosenProduct) {
        WebElement chosenProductTitle = chosenProduct.findElement(By.cssSelector(".product-title"));
        return chosenProductTitle.getText();
    }

}
