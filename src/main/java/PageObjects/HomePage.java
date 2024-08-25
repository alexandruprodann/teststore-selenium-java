package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.Objects;

public class HomePage extends BaseClass {

    // Elements
    private By productItemsListBy() {
        return By.cssSelector(".products > div");
    }

    private By searchBarBy() {
        return By.cssSelector(".ui-autocomplete-input");
    }

    private By clothesLinkBy() {
        return By.linkText("CLOTHES");
    }


    // Actions
    public void chooseRandomProduct() {
        List<WebElement> productItemsList = getDriver().findElements(productItemsListBy());
        int randomIndex = random.nextInt(productItemsList.size());
        WebElement chosenProduct = productItemsList.get(randomIndex);

        WebElement chosenProductTitle = chosenProduct.findElement(By.cssSelector(".product-title"));
        String chosenProductTitleString = chosenProductTitle.getText();

        if (Objects.equals(chosenProductTitleString, "Customizable Mug")) {
            chooseRandomProduct();
        }

        chosenProduct.click();
    }

    public void chooseRandomClothing() {
        getDriver().findElement(clothesLinkBy()).click();
        chooseRandomProduct();
    }

    public void searchSomething(String searchText) {
        waitUntilElementIsVisible(searchBarBy());
        WebElement searchBar = getDriver().findElement(searchBarBy());
        searchBar.sendKeys(searchText);
        pressEnter(searchBar);
    }

}
