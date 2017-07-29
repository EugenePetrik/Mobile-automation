import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static java.util.concurrent.TimeUnit.SECONDS;

public class FirstTestIOS {

    public static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) throws MalformedURLException {

        File classPathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classPathRoot, "app/iOS");
        File app = new File(appDir, "ContactsSimulator.app");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6 Simulator");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "F678F40D-B14D-4252-B1AD-1997CBB7DF11");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3.1");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, app);
        desiredCapabilities.setCapability("newCommandTimeout", 300);

        driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

        MobileElement mainSearch = driver.findElementById("main_search");
        mainSearch.sendKeys("Joy S");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
