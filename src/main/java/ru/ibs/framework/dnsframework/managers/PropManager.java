package ru.ibs.framework.dnsframework.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropManager {

    private static PropManager propManager;
    private Properties properties = new Properties();

    private PropManager() {
        initProperties();
    }

    public static PropManager getPropManager() {
        if (propManager == null) {
            propManager = new PropManager();
        }
        return propManager;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    private void initProperties() {
        String nameFile = System.getProperty("propFile", "application");
        try {
            properties.load(new FileInputStream("src\\main\\resources\\" + nameFile + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
