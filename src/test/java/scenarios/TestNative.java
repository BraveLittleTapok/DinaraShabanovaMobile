package scenarios;

import org.testng.annotations.Test;
import setup.PropertiesValue;
import steps.NativeSteps;

public class TestNative extends SettingsBeforeTest {
    private static final String title = "BudgetActivity";
    @Test(groups = "native", description = "Test for native app")
    public void NativeAppTest() {
        NativeSteps step = new NativeSteps(driver);
        step.clickRegisterNewUser();
        step.fillEmail(PropertiesValue.EMAIL);
        step.fillUserName(PropertiesValue.USER_NAME);
        step.fillPassword(PropertiesValue.PASSWORD);
        step.fillConfirmPassword(PropertiesValue.PASSWORD);
        step.clickRegisterButton();
        step.fillNameOnTheMainPage(PropertiesValue.EMAIL);
        step.fillPasswordOnTheMainPage(PropertiesValue.PASSWORD);
        step.clickSignIn();
        step.pageShouldBe(title);
        step.closeDriver();
    }

}
