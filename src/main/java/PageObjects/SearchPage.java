package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;

public class SearchPage extends BaseClass {

    // Elements
    private By searchResultsTitles() {
        return By.cssSelector(".product-title");
    }

    private By sortByDropdown() {
        return By.cssSelector(".sort-by-row button");
    }

    // Actions
    public boolean searchResultsDisplayedBool() {
        return getDriver().findElement(searchResultsTitles()).isDisplayed();
    }

    public String getSearchResultsText() {
        return getDriver().findElement(searchResultsTitles()).getText();
    }
}
