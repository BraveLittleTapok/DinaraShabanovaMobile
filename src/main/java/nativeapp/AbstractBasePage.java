package nativeapp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractBasePage {
    protected AppiumDriver driver;

    public AbstractBasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
