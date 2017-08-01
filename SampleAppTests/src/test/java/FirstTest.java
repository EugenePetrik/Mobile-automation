import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class FirstTest extends AbstractTest {

    @Test(description = "Find five elements")
    public void testFindFiveElements() throws Exception {

        if (platform.equals(Platform.ANDROID)) {

            ArrayList<MobileElement> arrrayAllContacts = findElementsByClassName("android.widget.ImageView");

            int i = 0;

            for (MobileElement arrayElement : arrrayAllContacts) {

                if (i == 5) break;

                arrayElement.click();

                String detailName = findElementById("detail_name").getText();

                MobileElement userImage = findElementByClassName("android.widget.ImageView");
                MobileElement userPhone = findElementById("phonenumber");
                MobileElement userEmail = findElementByXpath("//*[@resource-id=\"android:id/content\"]//*[@resource-id=\"com.jayway.contacts:id/email\"]");
                MobileElement userFirstAddress = findElementById("street1");
                MobileElement userSecondAddress = findElementById("street2");

                switch (detailName) {

                    case "Jenny Cherry" : {
                        Assert.assertTrue(userImage.isDisplayed());
                        Assert.assertEquals(userPhone.getText(), "+1(959)-1775994");
                        Assert.assertEquals(userEmail.getText(), "jqjenny16@yopmail.com");
                        Assert.assertEquals(userFirstAddress.getText(), "201 Metz Bates");
                        Assert.assertEquals(userSecondAddress.getText(), "15840 New York");
                        break;
                    }

                    case "Garance Epperson" : {
                        Assert.assertTrue(userImage.isDisplayed());
                        Assert.assertEquals(userPhone.getText(), "+1(747)-8330134");
                        Assert.assertEquals(userEmail.getText(), "duepperson20@gmail.com");
                        Assert.assertEquals(userFirstAddress.getText(), "542 American Circle");
                        Assert.assertEquals(userSecondAddress.getText(), "49100 Washington");
                        break;
                    }

                    case "Nadia Patten" : {
                        Assert.assertTrue(userImage.isDisplayed());
                        Assert.assertEquals(userPhone.getText(), "+1(131)-9550402");
                        Assert.assertEquals(userEmail.getText(), "jnnadia13@gmail.com");
                        Assert.assertEquals(userFirstAddress.getText(), "791 Bombardier Court");
                        Assert.assertEquals(userSecondAddress.getText(), "93809 New York");
                        break;
                    }

                    case "Jennifer Krantz" : {
                        Assert.assertTrue(userImage.isDisplayed());
                        Assert.assertEquals(userPhone.getText(), "+1(656)-6779916");
                        Assert.assertEquals(userEmail.getText(), "eekrantz4@yopmail.com");
                        Assert.assertEquals(userFirstAddress.getText(), "413 Wescam Drive");
                        Assert.assertEquals(userSecondAddress.getText(), "43115 Miami");
                        break;
                    }

                    case "Christin Steinberg" : {
                        Assert.assertTrue(userImage.isDisplayed());
                        Assert.assertEquals(userPhone.getText(), "+1(656)-1115633");
                        Assert.assertEquals(userEmail.getText(), "awchristin22@yahoo.com");
                        Assert.assertEquals(userFirstAddress.getText(), "412 Barfield Trail");
                        Assert.assertEquals(userSecondAddress.getText(), "53713 Houston");
                        break;
                    }

                    default : {
                        System.out.println("I didn't find this element");
                        break;
                    }

                }

                driver.navigate().back();
                i++;
            }

        } else if (platform.equals(Platform.IOS)) {

            ArrayList<MobileElement> arrrayAllContacts = findElementsByXpath("//XCUIElementTypeTable//XCUIElementTypeCell");

            int i = 0;

            for (MobileElement arrayElement : arrrayAllContacts) {

                if (i == 5) break;

                arrayElement.click();

                String detailName = findElementByXpath("//XCUIElementTypeOther/XCUIElementTypeStaticText[1]").getText();

                MobileElement userImage = findElementByAccessibilityId("contact_details");
                MobileElement userPhone = findElementByXpath("//XCUIElementTypeOther/XCUIElementTypeStaticText[3]");
                MobileElement userEmail = findElementByXpath("//XCUIElementTypeOther/XCUIElementTypeStaticText[5]");
                MobileElement userFirstAddress = findElementByXpath("//XCUIElementTypeOther/XCUIElementTypeStaticText[7]");
                MobileElement userSecondAddress = findElementByXpath("//XCUIElementTypeOther/XCUIElementTypeStaticText[8]");

                switch (detailName) {

                    case "Byron Workman" : {
                        Assert.assertTrue(userImage.isDisplayed());
                        Assert.assertEquals(userPhone.getText(), "+1(656)-6779916");
                        Assert.assertEquals(userEmail.getText(), "ggbyron6@yopmail.com");
                        Assert.assertEquals(userFirstAddress.getText(), "413 Wescam Drive");
                        Assert.assertEquals(userSecondAddress.getText(), "43115 Miami");
                        break;
                    }

                    case "Chris Heavener" : {
                        Assert.assertTrue(userImage.isDisplayed());
                        Assert.assertEquals(userPhone.getText(), "+1(959)-1775994");
                        Assert.assertEquals(userEmail.getText(), "ischris18@outlook.com");
                        Assert.assertEquals(userFirstAddress.getText(), "201 Metz Bates");
                        Assert.assertEquals(userSecondAddress.getText(), "15840 New York");
                        break;
                    }

                    case "Christin Steinberg" : {
                        Assert.assertTrue(userImage.isDisplayed());
                        Assert.assertEquals(userPhone.getText(), "+1(656)-1115633");
                        Assert.assertEquals(userEmail.getText(), "awchristin22@yahoo.com");
                        Assert.assertEquals(userFirstAddress.getText(), "412 Barfield Trail");
                        Assert.assertEquals(userSecondAddress.getText(), "53713 Houston");
                        break;
                    }

                    case "Dulcie Moller" : {
                        Assert.assertTrue(userImage.isDisplayed());
                        Assert.assertEquals(userPhone.getText(), "+1(555)-9779202");
                        Assert.assertEquals(userEmail.getText(), "eimoller8@yopmail.com");
                        Assert.assertEquals(userFirstAddress.getText(), "52 Woodside Way");
                        Assert.assertEquals(userSecondAddress.getText(), "58193 New Jersey");
                        break;
                    }

                    case "Duane Cedillo" : {
                        Assert.assertTrue(userImage.isDisplayed());
                        Assert.assertEquals(userPhone.getText(), "+1(141)-1779583");
                        Assert.assertEquals(userEmail.getText(), "hxduane23@gmail.com");
                        Assert.assertEquals(userFirstAddress.getText(), "438 Ethels Lane");
                        Assert.assertEquals(userSecondAddress.getText(), "24456 Houston");
                        break;
                    }

                    default : {
                        System.out.println("I didn't find this element");
                        break;
                    }

                }

                driver.navigate().back();
                i++;
            }
        }
    }

    @Test(description = "Negative Search")
    public void negativeSearch() throws Exception {

        if (platform.equals(Platform.ANDROID)) {

            MobileElement searchField = findElementById("main_search");
            searchField.sendKeys("123");

            ArrayList<MobileElement> userSearchEmpty = findElementsByClassName("android.widget.RelativeLayout");
            Assert.assertEquals(userSearchEmpty.size(), 0);

            MobileElement mainText = findElementById("main_text");
            Assert.assertEquals(mainText.getText(), "No contacts found with \"123\" in the name");

            searchField.clear();

        } else if (platform.equals(Platform.IOS)) {

            MobileElement mainSearch = findElementByAccessibilityId("Search for contact");
            mainSearch.setValue("123");

            ArrayList<MobileElement> userSearchEmpty = findElementsByXpath("//XCUIElementTypeTable/XCUIElementTypeCell[@visible=\"true\"]");
            Assert.assertEquals(userSearchEmpty.size(), 0);

            mainSearch.clear();

            findElementByXpath("//XCUIElementTypeOther/XCUIElementTypeButton[@name=\"Cancel\"]");

        }
    }

    @Test(description = "Positive Search")
    public void positiveSearch() {

        if (platform.equals(Platform.ANDROID)) {

            MobileElement searchField = findElementById("main_search");
            searchField.sendKeys("Li");

            ArrayList<MobileElement> userSearchNotEmpty = findElementsById("name");
            Assert.assertEquals(userSearchNotEmpty.size(), 2);

            searchField.clear();

        } else if (platform.equals(Platform.IOS)) {

            MobileElement mainSearch = findElementByAccessibilityId("Search for contact");
            mainSearch.setValue("Li");

            ArrayList<MobileElement> userSearchNotEmpty = findElementsByXpath("//XCUIElementTypeCell/XCUIElementTypeStaticText[@visible=\"true\"]");
            Assert.assertEquals(userSearchNotEmpty.size(), 2);

            MobileElement firstName = findElementByAccessibilityId("Lily Barnhill");
            MobileElement secondName = findElementByAccessibilityId("Philippe Meyerson");

            Assert.assertEquals(firstName.getText(), "Lily Barnhill");
            Assert.assertEquals(secondName.getText(), "Philippe Meyerson");

            mainSearch.clear();

            findElementByXpath("//XCUIElementTypeOther/XCUIElementTypeButton[@name=\"Cancel\"]");

        }

    }

    private static MobileElement findElementByClassName (String className) {
        return driver.findElement(By.className(className));
    }

    private static ArrayList<MobileElement> findElementsByClassName (String ClassName) {
        return (ArrayList<MobileElement>) driver.findElementsByClassName(ClassName);
    }

    private static MobileElement findElementByXpath (String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    private static ArrayList<MobileElement> findElementsByXpath (String xpath) {
        return (ArrayList<MobileElement>) driver.findElementsByXPath(xpath);
    }

    private static MobileElement findElementById (String id) {
        return driver.findElementById(id);
    }

    private static ArrayList<MobileElement> findElementsById (String Id) {
        return (ArrayList<MobileElement>) driver.findElementsById(Id);
    }

    private static MobileElement findElementByAccessibilityId (String id) {
        return driver.findElementByAccessibilityId(id);
    }

}
