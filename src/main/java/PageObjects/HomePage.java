package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.Objects;

public class HomePage extends BaseClass {

    // Elements
    private By productItemsList() {
        return By.cssSelector(".products > div");
    }

    private By searchBar() {
        return By.cssSelector(".ui-autocomplete-input");
    }

    private By clothesLink() {
        return By.cssSelector("#category-3");
    }

    private By accessoriesLink() {
        return By.cssSelector("#category-6");
    }

    private By signInLink() {
        return By.cssSelector(".user-info a");
    }

    private By cartLink() {
        return By.cssSelector(".blockcart");
    }

    private By contactUsLink() {
        return By.cssSelector("div#contact-link a");
    }

    private By hamburgerMenu() {
        return By.cssSelector("#menu-icon");
    }

    public By myAccountLink() {
        return By.cssSelector("a[title='View my customer account']");
    }

    private By allProductsLink() {
        return By.xpath("//a[contains(.,'All products')]");
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
