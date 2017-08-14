import enums.Browser;
import enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.URL;

import static enums.Platform.ANDROID;
import static enums.Platform.IOS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static pageobjects.web_app.BaseWebPage.browser;
import static pageobjects.native_app.BasePage.platform;

public class BaseTest {

    static {
        setPlatform();
        setBrowser();
    }

    static AppiumDriver<MobileElement> driver;

    private static void setPlatform() {
        String platformVal = System.getProperty("platform");

        if (platformVal != null) {
            platform = platformVal.contains("ios") ? IOS : ANDROID;
        } else {
            platform = ANDROID;
        }
    }

    public static void setBrowser() {
        String platformVal = System.getProperty("browser");

        if (platformVal != null) {
            browser = platformVal.contains("chrome") ? Browser.CHROME : Browser.SAFARI;
        } else {
            browser = Browser.NOTSET;
        }
    }

    @BeforeMethod
    public void setUp() throws Exception {
        URL remoteAddress = new URL("http://127.0.0.1:4723/wd/hub");

        if (browser.equals(Browser.CHROME)) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Nexus");
            desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 500);

            driver = new AndroidDriver<>(remoteAddress, desiredCapabilities);
        } else if (browser.equals(Browser.SAFARI)) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6 Simulator");
            desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.SAFARI);
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "F678F40D-B14D-4252-B1AD-1997CBB7DF11");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 500);

            driver = new IOSDriver<>(remoteAddress, desiredCapabilities);
        } else if (platform.equals(Platform.IOS)) {
            File classPathRoot = new File(System.getProperty("user.dir"));
            File appDir = new File(classPathRoot, "native_app/iOS");
            File app = new File(appDir, "FasTip.native_app");

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6 Simulator");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "F678F40D-B14D-4252-B1AD-1997CBB7DF11");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, app);
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            desiredCapabilities.setCapability("newCommandTimeout", 300);

            driver = new IOSDriver<>(remoteAddress, desiredCapabilities);
        } else if (platform.equals(Platform.ANDROID)) {
            File classPathRoot = new File(System.getProperty("user.dir"));
            File appDir = new File(classPathRoot, "native_app/Android");
            File app = new File(appDir, "FasTip.apk");

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Nexus");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, app);
            desiredCapabilities.setCapability("newCommandTimeout", 300);

            driver = new AndroidDriver<>(remoteAddress, desiredCapabilities);
        }

        driver.manage().timeouts().implicitlyWait(60, SECONDS);

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

}
