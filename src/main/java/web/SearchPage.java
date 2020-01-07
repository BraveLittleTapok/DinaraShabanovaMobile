package web;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BaseWebApp {

    public SearchPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@id='rso']/div[@class='srg']/div")
    List<WebElement> results;

    @FindBy(name = "q")
    private WebElement fieldSearch;

    public void performSearchWithText(String text) {
        fieldSearch.sendKeys(text + "\n");
    }

    public List<WebElement> getListOfResults() {
        return results;
    }

}
