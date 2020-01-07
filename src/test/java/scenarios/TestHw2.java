package scenarios;

import org.testng.annotations.Test;
import setup.PropertiesValue;
import steps.NativeSteps;
import steps.WebSteps;

public class TestHw2 extends BaseTest {

    private static final String textForSearch = "EPAM";
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
    }

    @Test(groups = "web", description = "Test for Web search")
    public void WebTest() {
        WebSteps steps = new WebSteps(driver);
        steps.openGoogleSearch();
        steps.performSearchWithText(textForSearch);
        steps.resultShouldContainsSeveralItems();
    }

}
