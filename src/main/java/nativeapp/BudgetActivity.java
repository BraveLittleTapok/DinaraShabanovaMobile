package nativeapp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BudgetActivity extends AbstractBasePage{

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/action_bar")
    private WebElement title;

    public BudgetActivity(AppiumDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return title.findElement(By.className("android.widget.TextView")).getText();
    }

}
