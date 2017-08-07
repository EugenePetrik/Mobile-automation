package pageobjects;

import enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindAll;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.util.ArrayList;

public class ContactsListPage extends BasePage {

    @iOSFindBy(accessibility = "Search for contact")
    @AndroidFindBy(id = "main_search")
    private MobileElement searchForContact;

    @iOSFindAll(@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@visible=\"true\"]"))
    @AndroidFindAll(@AndroidFindBy(id = "name"))
    private ArrayList<MobileElement> contactsCollection;

    @iOSFindAll(@iOSFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell"))
    private ArrayList<MobileElement> contactsCollectionForIOS;

    @iOSFindBy(accessibility = "Cancel")
    private MobileElement buttonCancel;

    @AndroidFindBy(id = "main_text")
    private MobileElement errorMessageText;

    private String fullname;

    public ContactsListPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public BasePage initializePage() {
        return null;
    }

    public void clickTheButtonCancel() {
        buttonCancel.click();
    }

    public ContactsListPage searchByName(String searchVal) {
        searchForContact.setValue(searchVal);
        this.fullname = searchVal;

        return this;
    }

    public boolean isSearchSuccessful() {
        boolean equals = contactsCollection.get(0).getText().equals(fullname);
        boolean size = contactsCollection.size() == 1;
        if (equals && size) {
            return true;
        } else {
            return false;
        }
    }

    public ContactsListPage clearSearch() {
        searchForContact.clear();

        return this;
    }

    public ContactDetailsPage clickToFirstName() {
        contactsCollection.get(0).click();

        return new ContactDetailsPage(driver);
    }

    public ArrayList<MobileElement> getAllActiveNames() {
        return contactsCollection;
    }

    public ArrayList<MobileElement> getAllNames() {
        return contactsCollectionForIOS;
    }

    public String getErorrMessageText() {
        return errorMessageText.getText();
    }

    public String selectContact(String fullname) {
        String locator = "";

        if (BasePage.platform.equals(Platform.ANDROID)) {
            locator = String.format("//android.widget.TextView[@text='%s']", fullname);
        } else if (BasePage.platform.equals(Platform.IOS)) {
            locator = String.format("//XCUIElementTypeStaticText[@name='%s']", fullname);
        }

        return driver.findElementByXPath(locator).getText();
    }

}
