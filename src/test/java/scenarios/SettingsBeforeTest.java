package scenarios;

import org.testng.annotations.BeforeGroups;
import setup.DriverSetup;
import setup.PropertiesValue;
import setup.TestProperties;

public class SettingsBeforeTest extends DriverSetup {
    private static TestProperties prop = new TestProperties();


    @BeforeGroups(groups = "web")
    public void setUpWeb() throws Exception {
        TestProperties.PATH_TO_PROPERTIES = "src/main/resources/ios.properties";
        PropertiesValue.AUT = prop.getPropertyByName("aut");
        PropertiesValue.SUT = prop.getPropertyByName("sut");
        prepareDriver();
    }

    @BeforeGroups(groups = "native")
    public void setUpNative() throws Exception {
        TestProperties.PATH_TO_PROPERTIES = "src/main/resources/android.properties";
        PropertiesValue.AUT = prop.getPropertyByName("aut");
        PropertiesValue.SUT = prop.getPropertyByName("sut");
        prepareDriver();
    }
}
