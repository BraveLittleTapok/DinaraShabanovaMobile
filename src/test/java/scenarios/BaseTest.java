package scenarios;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import setup.DriverSetup;
import setup.PropertiesValue;
import setup.TestPeoperties;

public class BaseTest extends DriverSetup {
    private static TestPeoperties prop = new TestPeoperties();

    @BeforeGroups(groups = "native")
    public void setUpNative() throws Exception {
        PropertiesValue.AUT = prop.getPropertyByName("aut");
        PropertiesValue.SUT = null;
        driver = null;
        prepareDriver();
    }

    @BeforeGroups(groups = "web")
    public void setUpWeb() throws Exception {
        PropertiesValue.SUT = prop.getPropertyByName("sut");
        PropertiesValue.AUT = null;
        driver = null;
        prepareDriver();
    }

    @AfterGroups
    public void tearDown() {
        driver.quit();
    }
}
