package steps;

import io.appium.java_client.AppiumDriver;
import setup.PropertiesValue;
import web.BaseWebApp;
import web.SearchPage;

import static org.testng.Assert.assertTrue;

public class WebSteps {

    private AppiumDriver driver;
    private BaseWebApp web;
    private SearchPage searchPage;

    public WebSteps(AppiumDriver driver) {
        this.driver = driver;
        this.web = new BaseWebApp(driver);
        this.searchPage = new SearchPage(driver);
    }

    public void openGoogleSearch() {
        driver.get(PropertiesValue.SUT);
    }

    public void performSearchWithText(String text) {
        searchPage.performSearchWithText(text);
    }

    public void resultShouldContainsSeveralItems() {
        assertTrue(!searchPage.getListOfResults().isEmpty());
    }
}
