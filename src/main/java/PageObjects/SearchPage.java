package PageObjects;

import org.openqa.selenium.By;

public class SearchPage extends BasePage {

    // Elements
    public By searchResultsTitlesBy() {
        return By.cssSelector(".product-title");
    }

    private By sortByDropdownBy() {
        return By.cssSelector(".sort-by-row button");
    }

    // Actions
    public boolean searchResultsDisplayedBool() {
        return driver.findElement(searchResultsTitlesBy()).isDisplayed();
    }

    public String getSearchResultsText() {
        return driver.findElement(searchResultsTitlesBy()).getText();
    }
}
