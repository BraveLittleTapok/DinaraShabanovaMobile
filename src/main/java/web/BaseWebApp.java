package web;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseWebApp {
    protected AppiumDriver driver;

    public BaseWebApp(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.android.chrome:id/url_bar")
    private WebElement searchField;

    public void performSearchWithText(String text){
       driver.get(text);
    }



}
