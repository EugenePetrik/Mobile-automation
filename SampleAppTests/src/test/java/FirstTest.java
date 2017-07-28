import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class FirstTest {

    public static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) throws MalformedURLException {

        File classPathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classPathRoot, "/app/Android");
        File app = new File(appDir, "Contacts.apk");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Nexus");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, app);
        desiredCapabilities.setCapability("appPackage", "com.jayway.contacts");
        desiredCapabilities.setCapability("appActivity", "com.jayway.contacts.MainActivity");
        desiredCapabilities.setCapability("newCommandTimeout", 300);

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);  // implicit wait

        MobileElement searchField = driver.findElement(By.id("main_search"));
        searchField.setValue("Joy S");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<MobileElement> name = driver.findElements(By.id("name"));
        Assert.assertEquals(name.size(), 1);    // Assert.assertTrue(name.size() == 1);

        for (MobileElement element : name) {
            element.getText().equals("Joy Stclair");
            element.click();
        }

        MobileElement image = driver.findElement(By.xpath("//*[@resource-id=\"android:id/content\"]//android.widget.ImageView"));

        // driver.findElement(By.className("android.widget.ImageView"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }

}
