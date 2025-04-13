package PageObjects;

import Utilities.BaseClass;
import Utilities.LocatorFactory;
import org.openqa.selenium.By;

import static Utilities.LocatorFactory.LocatorType.CSS_SELECTOR;
import static Utilities.LocatorFactory.LocatorType.XPATH;

public class FilterPage extends BaseClass {

    // Elements
    private By filterOption(String optionName) {
        return LocatorFactory.createLocator(XPATH, String.format("//a[contains(text(),'%s')]", optionName));
    }

    private By filterBtnMob() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "#search_filter_toggler");
    }

    private By filterCategoryMob(String filterCategory) {
        return LocatorFactory.createLocator(XPATH, String.format("//p[@class='h6 facet-title'][text()='%s']", filterCategory));
    }

    private By okBtnMob() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".btn.btn-secondary.ok");
    }

    public By filterBlock() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".filter-block");
    }


    // Actions
    public void filterBy(String filterCategory, String filter) {
        if (isMobile()) {
            clickFilterBtnMob();
            clickFilterCategoryMob(filterCategory);
            waitUntilElementIsClickable(filterOption(filter));
            jsClick(filterOption(filter));
            clickOkBtnMob();
        } else {
            waitUntilElementIsClickable(filterOption(filter));
            getDriver().findElement(filterOption(filter)).click();
        }
    }

    public void clickFilterBtnMob() {
        waitUntilElementIsClickable(filterBtnMob());
        getDriver().findElement(filterBtnMob()).click();
    }

    public void clickFilterCategoryMob(String filterCategory) {
        waitUntilElementIsClickable(filterCategoryMob(filterCategory));
        getDriver().findElement(filterCategoryMob(filterCategory)).click();
    }

    public void clickOkBtnMob() {
        scrollToElementCenter(okBtnMob());
        waitUntilElementIsClickable(okBtnMob());
        getDriver().findElement(okBtnMob()).click();
    }

}
