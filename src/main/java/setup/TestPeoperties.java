package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPeoperties {
    private static final String PATH_TO_PROPERTIES = "src/main/resources/test.properties";
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
