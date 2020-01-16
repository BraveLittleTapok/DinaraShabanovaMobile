package setup;

public class PropertiesValue {
    private static TestProperties prop = new TestProperties();
    public static final String DEVICE = prop.getPropertyByName("device");
    public static final String PLATFORM = prop.getPropertyByName("platform");
    public static final String DRIVER = String.format("http://EPM-TSTF:%s%s", System.getenv("TOKEN"),"@mobilecloud.epam.com:8080/wd/hub");

    public static final String EMAIL = prop.getPropertyByName("email");
    public static final String USER_NAME = prop.getPropertyByName("userName");
    public static final String PASSWORD = prop.getPropertyByName("password");

    public static final String APP_PACKAGE = prop.getPropertyByName("appPackage");
    public static final String APP_ACTIVITY = prop.getPropertyByName("appActivity");
    public static final String BUNDLE_ID = prop.getPropertyByName("bundleId");

    public static String AUT;
    public static String SUT;

}
