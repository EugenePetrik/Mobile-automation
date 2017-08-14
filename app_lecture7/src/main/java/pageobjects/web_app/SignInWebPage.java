package pageobjects.web_app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SignInWebPage extends BaseWebPage {

    @FindBy(id = "login")
    private MobileElement emailField;

    @FindBy(id = "password")
    private MobileElement passwordField;

    @FindBy(xpath = "//button[@name=\"do_login\"]")
    private MobileElement signInButton;

    public SignInWebPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public SignInWebPage initializePage() {
        return null;
    }

    public MainWebPage signInAsUser(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
        signInButton.click();

        return new MainWebPage(driver);
    }

}
