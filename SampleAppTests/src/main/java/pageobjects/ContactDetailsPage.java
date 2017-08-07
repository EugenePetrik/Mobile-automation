package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ContactDetailsPage extends BasePage {

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(id = "detail_name")
    private MobileElement userDetailName;

    @iOSFindBy(accessibility = "contact_details")
    @AndroidFindBy(className = "android.widget.ImageView")
    private MobileElement userImage;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[3]")
    @AndroidFindBy(id = "phonenumber")
    private MobileElement userPhone;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[5]")
    @AndroidFindBy(xpath = "//*[@resource-id=\"android:id/content\"]//*[@resource-id=\"com.jayway.contacts:id/email\"]")
    private MobileElement userEmail;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[7]")
    @AndroidFindBy(id = "street1")
    private MobileElement userFirstAddress;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[8]")
    @AndroidFindBy(id = "street2")
    private MobileElement userSecondAddress;

    public ContactDetailsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initializePage();
    }

    public ContactDetailsPage initializePage() {
        waitForElement(userImage);

        return this;
    }

    public String getUserDetailName() {
        return userDetailName.getText();
    }

    public boolean isUserImageDisplayed() {
        return userImage.isDisplayed();
    }

    public String getUserPhone() {
        return userPhone.getText();
    }

    public String getUserEmail() {
        return userEmail.getText();
    }

    public String getUserFirstAddress() {
        return userFirstAddress.getText();
    }

    public String getUserSecondAddress() {
        return userSecondAddress.getText();
    }

}
