package setup;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class DriverSetup {

    protected AppiumDriver driver;
    private DesiredCapabilities desiredCapabilities;

    protected void prepareDriver() throws Exception {
        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesValue.DEVICE);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertiesValue.PLATFORM);
        desiredCapabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

        if (PropertiesValue.AUT != null && PropertiesValue.SUT == null) {
            File app = new File(PropertiesValue.AUT);
            desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            driver = new AppiumDriver(new URL(PropertiesValue.DRIVER), desiredCapabilities);
        } else if (PropertiesValue.SUT != null && PropertiesValue.AUT == null) {
            desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, PropertiesValue.BROWSER);
            driver = new AppiumDriver(new URL(PropertiesValue.DRIVER), desiredCapabilities);
        } else {
            throw new Exception("Unclear type of mobile app");
        }
    }
}
