import enums.Platform;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.BasePage;
import pageobjects.ContactDetailsPage;
import pageobjects.ContactsListPage;

import java.util.ArrayList;

public class FirstTest extends BaseTest {

    @Test(description = "Find name")
    public void testSearch() throws Exception {
        boolean searchSuccessful = new ContactsListPage(driver)
                .searchByName("Byron Workman")
                .isSearchSuccessful();
        Assert.assertTrue(searchSuccessful);
    }

    @Test(description = "Select contact with specific name")
    public void testFindContactByName() throws Exception {
        ContactDetailsPage findContactByName = new ContactsListPage(driver)
                .searchByName("Byron Workman")
                .clickToFirstName();

        Assert.assertEquals(findContactByName.getUserDetailName(), "Byron Workman");

        findContactByName.returnBack();
    }

    @Test(description = "Negative Search")
    public void negativeSearch() throws Exception {

        if (BasePage.platform.equals(Platform.ANDROID)) {

            ArrayList<MobileElement> allNames = new ContactsListPage(driver)
                    .searchByName("123")
                    .getAllActiveNames();

            Assert.assertEquals(allNames.size(), 0);

            Assert.assertEquals(new ContactsListPage(driver)
                    .getErorrMessageText(), "No contacts found with \"123\" in the name");

            new ContactsListPage(driver).clearSearch();


        } else if (BasePage.platform.equals(Platform.IOS)) {

            ArrayList<MobileElement> allNames = new ContactsListPage(driver)
                    .searchByName("123")
                    .getAllActiveNames();

            Assert.assertEquals(allNames.size(), 0);

            new ContactsListPage(driver).clickTheButtonCancel();

        }

    }

    @Test(description = "Positive Search")
    public void positiveSearch() {

        if (BasePage.platform.equals(Platform.ANDROID)) {

            ArrayList<MobileElement> allNames = new ContactsListPage(driver)
                    .searchByName("Li")
                    .getAllActiveNames();

            Assert.assertEquals(allNames.size(), 2);

            Assert.assertEquals(new ContactsListPage(driver).selectContact("Lily Barnhill"), "Lily Barnhill");
            Assert.assertEquals(new ContactsListPage(driver).selectContact("Philippe Meyerson"), "Philippe Meyerson");

            new ContactsListPage(driver).clearSearch();

        } else if (BasePage.platform.equals(Platform.IOS)) {

            ArrayList<MobileElement> allNames = new ContactsListPage(driver)
                    .searchByName("Li")
                    .getAllActiveNames();

            Assert.assertEquals(allNames.size(), 2);

            Assert.assertEquals(new ContactsListPage(driver).selectContact("Lily Barnhill"), "Lily Barnhill");
            Assert.assertEquals(new ContactsListPage(driver).selectContact("Philippe Meyerson"), "Philippe Meyerson");

            new ContactsListPage(driver).clickTheButtonCancel();

        }

    }

    @Test(description = "Find five elements")
    public void testFindFiveElements() throws Exception {

        ContactsListPage contactsListPage = new ContactsListPage(driver);

        if (BasePage.platform.equals(Platform.ANDROID)) {

            for (int i = 0; i < 5; i++) {

                contactsListPage.getAllActiveNames().get(i).click();

                ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);

                switch (contactDetailsPage.getUserDetailName()) {

                    case "Jenny Cherry": {
                        Assert.assertTrue(contactDetailsPage.isUserImageDisplayed());
                        Assert.assertEquals(contactDetailsPage.getUserPhone(), "+1(959)-1775994");
                        Assert.assertEquals(contactDetailsPage.getUserEmail(), "jqjenny16@yopmail.com");
                        Assert.assertEquals(contactDetailsPage.getUserFirstAddress(), "201 Metz Bates");
                        Assert.assertEquals(contactDetailsPage.getUserSecondAddress(), "15840 New York");
                        break;
                    }

                    case "Garance Epperson": {
                        Assert.assertTrue(contactDetailsPage.isUserImageDisplayed());
                        Assert.assertEquals(contactDetailsPage.getUserPhone(), "+1(747)-8330134");
                        Assert.assertEquals(contactDetailsPage.getUserEmail(), "duepperson20@gmail.com");
                        Assert.assertEquals(contactDetailsPage.getUserFirstAddress(), "542 American Circle");
                        Assert.assertEquals(contactDetailsPage.getUserSecondAddress(), "49100 Washington");
                        break;
                    }

                    case "Nadia Patten": {
                        Assert.assertTrue(contactDetailsPage.isUserImageDisplayed());
                        Assert.assertEquals(contactDetailsPage.getUserPhone(), "+1(131)-9550402");
                        Assert.assertEquals(contactDetailsPage.getUserEmail(), "jnnadia13@gmail.com");
                        Assert.assertEquals(contactDetailsPage.getUserFirstAddress(), "791 Bombardier Court");
                        Assert.assertEquals(contactDetailsPage.getUserSecondAddress(), "93809 New York");
                        break;
                    }

                    case "Jennifer Krantz": {
                        Assert.assertTrue(contactDetailsPage.isUserImageDisplayed());
                        Assert.assertEquals(contactDetailsPage.getUserPhone(), "+1(656)-6779916");
                        Assert.assertEquals(contactDetailsPage.getUserEmail(), "eekrantz4@yopmail.com");
                        Assert.assertEquals(contactDetailsPage.getUserFirstAddress(), "413 Wescam Drive");
                        Assert.assertEquals(contactDetailsPage.getUserSecondAddress(), "43115 Miami");
                        break;
                    }

                    case "Christin Steinberg": {
                        Assert.assertTrue(contactDetailsPage.isUserImageDisplayed());
                        Assert.assertEquals(contactDetailsPage.getUserPhone(), "+1(656)-1115633");
                        Assert.assertEquals(contactDetailsPage.getUserEmail(), "awchristin22@yahoo.com");
                        Assert.assertEquals(contactDetailsPage.getUserFirstAddress(), "412 Barfield Trail");
                        Assert.assertEquals(contactDetailsPage.getUserSecondAddress(), "53713 Houston");
                        break;
                    }

                    default: {
                        System.out.println("I didn't find this element");
                        break;
                    }

                }

                contactDetailsPage.returnBack();

            }
        } else if (BasePage.platform.equals(Platform.IOS)) {

            for (int i = 0; i < 5; i++) {

                contactsListPage.getAllNames().get(i).click();

                ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);

                switch (contactDetailsPage.getUserDetailName()) {

                    case "Byron Workman" : {
                        Assert.assertTrue(contactDetailsPage.isUserImageDisplayed());
                        Assert.assertEquals(contactDetailsPage.getUserPhone(), "+1(656)-6779916");
                        Assert.assertEquals(contactDetailsPage.getUserEmail(), "ggbyron6@yopmail.com");
                        Assert.assertEquals(contactDetailsPage.getUserFirstAddress(), "413 Wescam Drive");
                        Assert.assertEquals(contactDetailsPage.getUserSecondAddress(), "43115 Miami");
                        break;
                    }

                    case "Chris Heavener" : {
                        Assert.assertTrue(contactDetailsPage.isUserImageDisplayed());
                        Assert.assertEquals(contactDetailsPage.getUserPhone(), "+1(959)-1775994");
                        Assert.assertEquals(contactDetailsPage.getUserEmail(), "ischris18@outlook.com");
                        Assert.assertEquals(contactDetailsPage.getUserFirstAddress(), "201 Metz Bates");
                        Assert.assertEquals(contactDetailsPage.getUserSecondAddress(), "15840 New York");
                        break;
                    }

                    case "Christin Steinberg" : {
                        Assert.assertTrue(contactDetailsPage.isUserImageDisplayed());
                        Assert.assertEquals(contactDetailsPage.getUserPhone(), "+1(656)-1115633");
                        Assert.assertEquals(contactDetailsPage.getUserEmail(), "awchristin22@yahoo.com");
                        Assert.assertEquals(contactDetailsPage.getUserFirstAddress(), "412 Barfield Trail");
                        Assert.assertEquals(contactDetailsPage.getUserSecondAddress(), "53713 Houston");
                        break;
                    }

                    case "Dulcie Moller" : {
                        Assert.assertTrue(contactDetailsPage.isUserImageDisplayed());
                        Assert.assertEquals(contactDetailsPage.getUserPhone(), "+1(555)-9779202");
                        Assert.assertEquals(contactDetailsPage.getUserEmail(), "eimoller8@yopmail.com");
                        Assert.assertEquals(contactDetailsPage.getUserFirstAddress(), "52 Woodside Way");
                        Assert.assertEquals(contactDetailsPage.getUserSecondAddress(), "58193 New Jersey");
                        break;
                    }

                    case "Duane Cedillo" : {
                        Assert.assertTrue(contactDetailsPage.isUserImageDisplayed());
                        Assert.assertEquals(contactDetailsPage.getUserPhone(), "+1(141)-1779583");
                        Assert.assertEquals(contactDetailsPage.getUserEmail(), "hxduane23@gmail.com");
                        Assert.assertEquals(contactDetailsPage.getUserFirstAddress(), "438 Ethels Lane");
                        Assert.assertEquals(contactDetailsPage.getUserSecondAddress(), "24456 Houston");
                        break;
                    }

                    default : {
                        System.out.println("I didn't find this element");
                        break;
                    }

                }

                contactDetailsPage.returnBack();

            }
        }
    }

}
