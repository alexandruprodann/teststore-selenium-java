package PageObjects;

import Utilities.BaseClass;
import Utilities.LocatorFactory;
import Utilities.LocatorFactory.LocatorType;
import org.openqa.selenium.By;

import static Utilities.LocatorFactory.LocatorType.XPATH;

public class OrderHistoryPage extends BaseClass {

    // Elements
    public By orderHistoryTable() {
        return LocatorFactory.createLocator(LocatorType.CSS_SELECTOR, "table.table-striped", ".orders");
    }

    private By orderReference(int row) {
        return LocatorFactory.createLocator(XPATH, String.format("//table/tbody/tr[%d]/th", row));
    }

    private By orderDateByReference(String orderReference) {
        return LocatorFactory.createLocator(XPATH, "//table/tbody/tr[th[text()='" + orderReference + "']]/td[1]");
    }

    private By orderTotalPriceByReference(String orderReference) {
        return LocatorFactory.createLocator(XPATH, "//table/tbody/tr[th[text()='" + orderReference + "']]/td[2]");
    }

    private By orderPaymentMethodByReference(String orderReference) {
        return LocatorFactory.createLocator(XPATH, "//table/tbody/tr[th[text()='" + orderReference + "']]/td[3]");
    }

    private By orderStatusByReference(String orderReference) {
        return LocatorFactory.createLocator(XPATH, "//table/tbody/tr[th[text()='" + orderReference + "']]/td[4]/span");
    }


    // Actions
    public String getOrderReference(int row) {
        return getTextFromElement(orderReference(row));
    }
}
