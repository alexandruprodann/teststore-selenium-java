package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;

public class SearchPage extends BaseClass {

    // Elements
    public By searchResultsTitlesBy() {
        return By.cssSelector(".product-title");
    }

    private By sortByDropdownBy() {
        return By.cssSelector(".sort-by-row button");
    }

    // Actions
    public boolean searchResultsDisplayedBool() {
        return getDriver().findElement(searchResultsTitlesBy()).isDisplayed();
    }

    public String getSearchResultsText() {
        return getDriver().findElement(searchResultsTitlesBy()).getText();
    }
}
