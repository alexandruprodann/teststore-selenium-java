package PageObjects;

import Utilities.BaseClass;
import Utilities.LocatorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Utilities.LocatorFactory.LocatorType.XPATH;

public class SitemapPage extends BaseClass {

    // Elements
    private By links() {
        return LocatorFactory.createLocator(XPATH, "//section[@id='main']//a");
    }


    // Actions
    public List<WebElement> getLinkList() {
        return getDriver().findElements(links());
    }
}
