package pageobjects.web_app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterWebPage extends BaseWebPage {

    @FindBy(id = "user_email")
    private MobileElement emailFieldRegister;

    @FindBy(id = "user_password")
    private MobileElement passwordFieldRegister;

    @FindBy(id = "submit_form")
    private MobileElement buttonRegister;

    private final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss");
    Date date = new Date();
    public final String USERNAME = sdf.format(date) + "@example.com";

    public RegisterWebPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public RegisterWebPage initializePage() {
        return null;
    }

    public MainWebPage registerAsUser() {
        emailFieldRegister.setValue(USERNAME);
        passwordFieldRegister.setValue("qwerty");
        buttonRegister.click();

        return new MainWebPage(driver);
    }

}
