package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SettingsPage extends BasePage {

    @iOSFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(id = "org.traeg.fastip:id/tipPercentageEditText")
    private MobileElement newTipPercentage;

    @iOSFindBy(accessibility = "FastTip")
    private MobileElement backToMainScreen;

    @iOSFindBy(accessibility = "Done")
    @AndroidFindBy(id = "org.traeg.fastip:id/saveSettingsButton")
    private MobileElement saveSettings;

    public SettingsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public SettingsPage initializePage() {
        waitForElement(newTipPercentage);

        return this;
    }

    public SettingsPage enterNewTipPercentage(String tipPercentage) {
        newTipPercentage.clear();
        newTipPercentage.setValue(tipPercentage);

        return new SettingsPage(driver);
    }

    public MainPage clickTheButtonDone() {
        saveSettings.click();

        return new MainPage(driver);
    }

}
