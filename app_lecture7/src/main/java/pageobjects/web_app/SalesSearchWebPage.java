package pageobjects.web_app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SalesSearchWebPage extends BaseWebPage {

    public SalesSearchWebPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public SalesSearchWebPage initializePage() {
        return null;
    }

    public boolean isPageTitle(String title) {
        return driver.getTitle().equals(title);
    }

}
