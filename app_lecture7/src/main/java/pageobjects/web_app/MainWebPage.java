package pageobjects.web_app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class MainWebPage extends BaseWebPage {

    @FindBy(className = "MenuMobileButton")
    private MobileElement navElement;

    @FindBy(className = "MobileUpsellBanner-close")
    private MobileElement banner;

    @FindBy(xpath = "//*[@id=\"singin-menu\"]//a[contains(text(), \"Sign In\")]")
    private MobileElement linkSignIn;

    @FindBy(xpath = "//*[@id=\"singin-menu\"]//a[contains(text(), \"Register\")]")
    private MobileElement linkRegister;

    @FindBy(xpath = "//*[@id=\"navbar_menu\"]//a[contains(text(), \"Sales\")]")
    private MobileElement linkSales;

    @FindBy(xpath = "//*[@id=\"navbar_menu\"]//a[contains(text(), \"Rentals\")]")
    private MobileElement linkRentals;

    @FindBy(xpath = "//*[@id=\"navbar_menu\"]//a[contains(text(), \"Buildings\")]")
    private MobileElement linkBuildings;

    @FindBy(id = "flash_notice_inner")
    private MobileElement flashMessage;

    @FindBy(css = ".search-button .submit-search")
    private MobileElement salesSearchButton;

    public static final String BASEURL = "http://site.example.com";

    public MainWebPage openPage() {
        driver.get(BASEURL);
        return this;
    }

    public MainWebPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public MainWebPage initializePage() {
        waitForElement(banner);
        return null;
    }

    public MainWebPage closebanner() {
        banner.click();

        return this;
    }

    public MainWebPage openNavMenu() {
        navElement.click();

        return this;
    }

    public SignInWebPage clickToSignInLink() {
        linkSignIn.click();

        return new SignInWebPage(driver);
    }

    public boolean isSuccessfullSignInOrRegister(String message) {
        String getMessage = flashMessage.getText();

        return getMessage.contains(message);
    }

    public RegisterWebPage clickToRegisterLink() {
        linkRegister.click();

        return new RegisterWebPage(driver);
    }

    public SalesSearchWebPage clickTheButtonSearch() {
        salesSearchButton.click();

        return new SalesSearchWebPage(driver);
    }

    public MainWebPage clickToLinkSales() {
        linkSales.click();

        return this;
    }

}
