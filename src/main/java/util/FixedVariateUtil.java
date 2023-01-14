package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class FixedVariateUtil {

    private static final String RESOURCE_PATH = System.getProperty("user.dir") + "/src/main/resources/";
    public static String getFixedVariate(String fixedVariateName, String fileName){
        Properties fixedVariate = null;
        try {
            fixedVariate = new Properties();
            BufferedReader reader = new BufferedReader(new FileReader(RESOURCE_PATH + fileName));
            fixedVariate.load(reader);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return fixedVariate.getProperty(fixedVariateName);
    }
}
