import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.URL;

import static java.util.concurrent.TimeUnit.SECONDS;

public class AbstractTest {

    public static AppiumDriver<MobileElement> driver;
    protected static Platform platform = Platform.IOS;

    enum Platform {
        ANDROID,
        IOS
    }

    @BeforeTest
    public void setUp() throws Exception {
        if (platform.equals(Platform.IOS)) {
            File classPathRoot = new File(System.getProperty("user.dir"));
            File appDir = new File(classPathRoot, "app/iOS");
            File app = new File(appDir, "ContactsSimulator.app");

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6 Simulator");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "F678F40D-B14D-4252-B1AD-1997CBB7DF11");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, app);
            desiredCapabilities.setCapability("newCommandTimeout", 300);

            driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } else if (platform.equals(Platform.ANDROID)) {
            File classPathRoot = new File(System.getProperty("user.dir"));
            File appDir = new File(classPathRoot, "app/Android");
            File app = new File(appDir, "Contacts.apk");

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Nexus");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, app);
            desiredCapabilities.setCapability("appPackage", "com.jayway.contacts");
            desiredCapabilities.setCapability("appActivity", "com.jayway.contacts.MainActivity");
            desiredCapabilities.setCapability("newCommandTimeout", 300);

            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        }

        driver.manage().timeouts().implicitlyWait(5, SECONDS); // implicit wait (неявный wait - поиск каждого элемента не менее 2 секунд)
    }

    @AfterTest
    public void quiteDriver() throws Exception {
        driver.quit();
    }

}
