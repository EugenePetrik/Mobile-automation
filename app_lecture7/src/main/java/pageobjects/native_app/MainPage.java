package pageobjects.native_app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class MainPage extends BasePage {

    @iOSFindBy(accessibility = "Settings")
    @AndroidFindBy(id = "org.traeg.fastip:id/menu_settings")
    private MobileElement settingsLink;

    @iOSFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(id = "org.traeg.fastip:id/billAmtEditText")
    private MobileElement billAmount;

    @iOSFindBy(accessibility = "Calculate Tip")
    @AndroidFindBy(id = "org.traeg.fastip:id/calcTipButton")
    private MobileElement calculateTip;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(id = "org.traeg.fastip:id/tipAmtTextView")
    private MobileElement tipAmount;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[4]")
    @AndroidFindBy(id = "org.traeg.fastip:id/totalAmtTextView")
    private MobileElement totalAmount;

    public MainPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public MainPage initializePage() {
        return null;
    }

    public MainPage enterCheckAmount(String checkAmount) {
        billAmount.setValue(checkAmount);

        return this;
    }

    public MainPage clickTheButtonCalculateTip() {
        calculateTip.click();

        return this;
    }

    public boolean getTipAmount(String name) {
        String tip = tipAmount.getText();

        return tip.equals(name);
    }

    public boolean getTotalAmount(String name) {
        String amount = totalAmount.getText();

        return amount.equals(name);
    }

    public SettingsPage clickToSettings() {
        settingsLink.click();

        return new SettingsPage(driver);
    }

}
