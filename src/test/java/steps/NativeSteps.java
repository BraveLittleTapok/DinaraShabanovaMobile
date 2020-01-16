package steps;

import io.appium.java_client.AppiumDriver;
import nativeapp.BudgetActivity;
import nativeapp.MainPage;
import nativeapp.RegisterNewAccount;
import setup.DriverSetup;

import static org.testng.Assert.assertEquals;

public class NativeSteps extends DriverSetup {
    private MainPage mainPage;
    private RegisterNewAccount registerPage;
    private BudgetActivity activity;
    private AppiumDriver driver;

    public NativeSteps(AppiumDriver driver) {
        this.driver = driver;
        this.mainPage = new MainPage(driver);
        this.registerPage = new RegisterNewAccount(driver);
        this.activity = new BudgetActivity(driver);
    }

    public void clickRegisterNewUser() {
        mainPage.clickRegisterNewAcc();
    }

    public void fillEmail(String email) {
        registerPage.fillEmail(email);
    }

    public void fillUserName(String name) {
        registerPage.fillUserName(name);
    }

    public void fillPassword(String password) {
        registerPage.fillPassword(password);
    }

    public void fillConfirmPassword(String password) {
        registerPage.confirmPassword(password);
    }

    public void clickRegisterButton() {
        registerPage.clickButtonRegisterNewAcc();
    }

    public void fillNameOnTheMainPage(String name) {
        mainPage.fillLogin(name);
    }

    public void fillPasswordOnTheMainPage(String password) {
        mainPage.fillPassword(password);
    }

    public void clickSignIn() {
        mainPage.clickSighIn();
    }

    public void pageShouldBe(String title) {
        assertEquals(activity.getTitle(), title);
    }

    public void closeDriver() {
        driver.quit();
    }
}
