package setup;

import api.MobileApi;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.restassured.http.ContentType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

import static setup.PropertiesValue.*;

public class DriverSetup {

    protected AppiumDriver driver;
    private DesiredCapabilities desiredCapabilities;
    private String BROWSER;

    protected void prepareDriver() throws Exception {
        switch (PropertiesValue.PLATFORM) {
            case "Android":
                BROWSER = "Chrome";
                break;
            case "Ios":
                BROWSER = "Safari";
                break;
        }

        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM);
        //desiredCapabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

        if (PropertiesValue.AUT != null && PropertiesValue.SUT == null) {
            File app = new File(PropertiesValue.AUT);
            desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getPath());
            desiredCapabilities.setCapability("appPackage", APP_PACKAGE);
            desiredCapabilities.setCapability("appActivity", APP_ACTIVITY);
            desiredCapabilities.setCapability("bundleId", BUNDLE_ID);
            desiredCapabilities.setCapability("keepDevice", true);
            MobileApi
                    .with()
                    .path(String.format("device/%s", UDID))
                    .callApi(System.getenv("TOKEN")).prettyPeek();
            MobileApi
                    .with()
                    .path(String.format("storage/install/%s", UDID))
                    .contentType(ContentType.ANY)
                    .multipart(app)
                    .callApi(System.getenv("TOKEN")).prettyPeek();
            driver = new AppiumDriver(new URL(System.getenv("DRIVER")), desiredCapabilities);
        } else if (PropertiesValue.SUT != null && PropertiesValue.AUT == null) {
            desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BROWSER);
            driver = new AppiumDriver(new URL(System.getenv("DRIVER")), desiredCapabilities);
        } else {
            throw new Exception("Unclear type of mobile app");
        }

    }

}
