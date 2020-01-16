package scenarios;

import org.testng.annotations.Test;
import steps.WebSteps;

public class TestWeb extends SettingsBeforeTest {

    private static final String textForSearch = "EPAM";
    @Test(groups = "web", description = "Test for Web search")
    public void WebTest() throws InterruptedException {
        WebSteps steps = new WebSteps(driver);
        steps.openGoogleSearch();
        steps.performSearchWithText(textForSearch);
        steps.resultShouldContainsSeveralItems();
    }

}
