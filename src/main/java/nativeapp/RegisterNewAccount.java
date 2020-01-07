package nativeapp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterNewAccount extends AbstractBasePage{
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    private WebElement email;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    private WebElement userName;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    private WebElement password;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    private WebElement confirmPassword;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    private WebElement buttonRegister;

    public RegisterNewAccount(AppiumDriver driver) {
        super(driver);
    }

    public void fillEmail(String mail) {
        email.sendKeys(mail);
    }

    public void fillUserName(String name) {
        userName.sendKeys(name);
    }

    public void fillPassword(String passw) {
        password.sendKeys(passw);
    }

    public void confirmPassword(String passw) {
        confirmPassword.sendKeys(passw);
    }

    public void clickButtonRegisterNewAcc() {

        buttonRegister.click();
    }
}
