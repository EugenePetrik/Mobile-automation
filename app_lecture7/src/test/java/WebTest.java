import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.web_app.MainWebPage;
import pageobjects.web_app.SalesSearchWebPage;

public class WebTest extends BaseTest {

    @Test(description = "Sign in with correct credentials")
    public void signInWithCorrectCredentials() throws Exception {
        MainWebPage mainWebPage = new MainWebPage(driver)
                .openPage();

        Thread.sleep(1000);

        mainWebPage.openNavMenu()
                .closebanner()
                .clickToSignInLink()
                .signInAsUser("user1@example.com", "1234");

        Thread.sleep(1000);

        Assert.assertTrue(mainWebPage.isSuccessfullSignInOrRegister("You have successfully logged in!"));
    }

    @Test(description = "Sign in with incorrect credentials")
    public void signInWithInCorrectCredentials() throws Exception {
        MainWebPage mainWebPage = new MainWebPage(driver)
                .openPage();

        Thread.sleep(1000);

        mainWebPage.openNavMenu()
                .closebanner()
                .clickToSignInLink()
                .signInAsUser("user1@example.com", "123456");

        Thread.sleep(1000);

        Assert.assertTrue(mainWebPage.isSuccessfullSignInOrRegister("Invalid login or password."));
    }

    @Test(description = "Register as user")
    public void registerAsUser() throws Exception {
        MainWebPage mainWebPage = new MainWebPage(driver)
                .openPage();

        Thread.sleep(1000);

        mainWebPage.openNavMenu()
                .closebanner()
                .clickToRegisterLink()
                .registerAsUser();

        Thread.sleep(1000);

        Assert.assertTrue(mainWebPage.isSuccessfullSignInOrRegister("Thanks for signing up!"));
    }

    @Test(description = "Make Sales search by default")
    public void makeSalesSearchByDefault() throws Exception {
        MainWebPage mainWebPage = new MainWebPage(driver)
                .openPage();

        Thread.sleep(1000);

        mainWebPage.openNavMenu()
                .closebanner()
                .clickToLinkSales()
                .clickTheButtonSearch();

        Thread.sleep(1000);

        SalesSearchWebPage saleWebPage = new SalesSearchWebPage(driver);
        Assert.assertTrue(saleWebPage.isPageTitle("Some site page | Site name"));

        Thread.sleep(1000);
    }

}
