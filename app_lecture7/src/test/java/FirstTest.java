import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MainPage;
import pageobjects.SettingsPage;

public class FirstTest extends BaseTest {

    @Test(description = "Getting amount with default tip")
    public void amountWithDefaultTip() throws Exception {
        MainPage defaultAmount = new MainPage(driver)
                .enterCheckAmount("1000")
                .clickTheButtonCalculateTip();

        Assert.assertTrue(defaultAmount.getTipAmount("$150.00"));
        Assert.assertTrue(defaultAmount.getTotalAmount("$1150.00"));

    }

    @Test(description = "Getting amount with custom tip")
    public void amountWithCustomTip() throws Exception {
        new MainPage(driver).clickToSettings().enterNewTipPercentage("20.20");

        MainPage mainPage = new SettingsPage(driver)
                .clickTheButtonDone();

        mainPage.enterCheckAmount("2000").clickTheButtonCalculateTip();

        Assert.assertTrue(mainPage.getTipAmount("$404.00"));
        Assert.assertTrue(mainPage.getTotalAmount("$2404.00"));

    }

}
