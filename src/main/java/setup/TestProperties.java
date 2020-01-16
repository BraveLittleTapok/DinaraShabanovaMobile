package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    public static String PATH_TO_PROPERTIES;
    Properties currentProps = new Properties();

    Properties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream(PATH_TO_PROPERTIES);
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    public String getPropertyByName(String propKey) {
        if (!currentProps.containsKey(propKey)) {
            try {
                currentProps = getCurrentProps();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return currentProps.getProperty(propKey, null);

    }
}
