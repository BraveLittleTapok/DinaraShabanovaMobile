package setup;

public class PropertiesValue {
    private static TestPeoperties prop = new TestPeoperties();
    public static final String BROWSER = prop.getPropertyByName("browser");
    public static final String DEVICE = prop.getPropertyByName("device");
    public static final String PLATFORM = prop.getPropertyByName("platform");
    public static final String DRIVER = prop.getPropertyByName("driver");

    public static final String EMAIL = prop.getPropertyByName("email");
    public static final String USER_NAME = prop.getPropertyByName("userName");
    public static final String PASSWORD = prop.getPropertyByName("password");

    public static String AUT;
    public static String SUT;

}
