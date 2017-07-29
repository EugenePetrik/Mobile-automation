import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
        driver.manage().timeouts().implicitlyWait(2, SECONDS);  // implicit wait (неявный wait - поиск каждого элемента не менее 2 секунд)

//        MobileElement searchField = driver.findElement(By.id("main_search"));   // driver.findElementById("main_search");
//        searchField.setValue("Joy S");                                          // searchField.sendKeys("Joy S");
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//
//
//        MobileElement elementByXpath = driver.findElementByXPath("//android.widget.TextView[@resource-id=\"com.jayway.contacts:id/name\"]");
//        elementByXpath.click();
//
//        String email = findElementById("email").getText();
//
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);    // explicit wait
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
//        System.out.println(email.equals("alstclair11@yopmail.com"));
//
//
//
//
//        List<MobileElement> name = driver.findElements(By.id("name"));
//        Assert.assertEquals(name.size(), 1);    // Assert.assertTrue(name.size() == 1);
//
//        for (MobileElement element : name) {
//            element.getText().equals("Joy Stclair");
//            element.click();
//        }
//
//        MobileElement image = driver.findElement(By.xpath("//*[@resource-id=\"android:id/content\"]//android.widget.ImageView"));




        // ========================== Homework ==========================

        ArrayList<MobileElement> arrrayAllContacts = (ArrayList<MobileElement>) driver.findElements(By.className("android.widget.ImageView"));

        int i = 0;

        for (MobileElement arrayElement : arrrayAllContacts) {

            if (i == 5) {
                break;
            }

            arrayElement.click();

            String detailName = findElementById("detail_name").getText();

            MobileElement userImage = findElementByClassName("android.widget.ImageView");
            MobileElement userPhone = findElementById("phonenumber");
            MobileElement userEmail = findElementByXpath("//*[@resource-id=\"android:id/content\"]//*[@resource-id=\"com.jayway.contacts:id/email\"]");
            MobileElement userFirstAddress = findElementById("street1");
            MobileElement userSecondAddress = findElementById("street2");

            switch (detailName) {

                case "Jenny Cherry" : {

                    userImage.isDisplayed();
                    userPhone.getText().equals("+1(959)-1775994");
                    userEmail.getText().equals("jqjenny16@yopmail.com");
                    userFirstAddress.getText().equals("201 Metz Bates");
                    userSecondAddress.getText().equals("15840 New York");
                    break;
                }

                case "Garance Epperson" : {

                    userImage.isDisplayed();
                    userPhone.getText().equals("+1(747)-8330134");
                    userEmail.getText().equals("duepperson20@gmail.com");
                    userFirstAddress.getText().equals("542 American Circle");
                    userSecondAddress.getText().equals("49100 Washington");
                    break;
                }

                case "Nadia Patten" : {

                    userImage.isDisplayed();
                    userPhone.getText().equals("+1(131)-9550402");
                    userEmail.getText().equals("jnnadia13@gmail.com");
                    userFirstAddress.getText().equals("791 Bombardier Court");
                    userSecondAddress.getText().equals("93809 New York");
                    break;
                }

                case "Jennifer Krantz" : {

                    userImage.isDisplayed();
                    userPhone.getText().equals("+1(656)-6779916");
                    userEmail.getText().equals("eekrantz4@yopmail.com");
                    userFirstAddress.getText().equals("413 Wescam Drive");
                    userSecondAddress.getText().equals("43115 Miami");
                    break;
                }

                case "Christin Steinberg" : {

                    userImage.isDisplayed();
                    userPhone.getText().equals("+1(656)-6779916");
                    userEmail.getText().equals("eekrantz4@yopmail.com");
                    userFirstAddress.getText().equals("413 Wescam Drive");
                    userSecondAddress.getText().equals("43115 Miami");
                    break;
                }

                default : {
                    System.out.println("I didn't find this element");
                    break;
                }

            }

            driver.navigate().back();
            i++;
            continue;
        }

        MobileElement searchField = findElementById("main_search");
        searchField.sendKeys("123");

        List<MobileElement> userSearchEmpty = driver.findElements(By.className("android.widget.RelativeLayout"));
        Assert.assertEquals(userSearchEmpty.size(), 0);

        MobileElement mainText = findElementById("main_text");
        mainText.getText().equals("No contacts found with \"123\" in the name");

        searchField.clear();

        searchField.sendKeys("Li");

        List<MobileElement> userSearchNotEmpty = driver.findElementsById("name");
        Assert.assertEquals(userSearchNotEmpty.size(), 2);

        driver.quit();
    }

    private static MobileElement findElementById (String id) {
        return (MobileElement) driver.findElementById(id);
    }

    private static MobileElement findElementByXpath (String xpath) {
        return (MobileElement) driver.findElement(By.xpath(xpath));
    }

    private static MobileElement findElementByClassName (String className) {
        return (MobileElement) driver.findElement(By.className(className));
    }

}
