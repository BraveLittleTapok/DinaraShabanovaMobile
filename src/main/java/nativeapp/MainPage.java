package nativeapp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractBasePage {

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    private WebElement loginName;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    private WebElement password;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    private WebElement signIn;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private WebElement buttonRegister;

    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    public void fillLogin(String name) {
        loginName.sendKeys(name);
    }

    public void fillPassword(String passw) {
        password.sendKeys(passw);
    }

    public void clickSighIn() {
        signIn.click();
    }

    public void clickRegisterNewAcc() {
        buttonRegister.click();
    }
}
