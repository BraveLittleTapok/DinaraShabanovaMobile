package web;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends BaseWebApp {

    public SearchPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@id='rso']/div[@class='srg']/div")
    private List<WebElement> results;

    @FindBy(name = "q")
    private WebElement fieldSearch;

    @FindBy(className = "Tg7LZd")
    private WebElement button;

    public void performSearchWithText(String text) {
        fieldSearch.sendKeys(text);
        button.click();
    }

    public List<WebElement> getListOfResults() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath(".//*[@id='rso']/div[@class='srg']/div"),0));
        return results;
    }

}
