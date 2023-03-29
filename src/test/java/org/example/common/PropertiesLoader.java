package org.example.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;


public final class PropertiesLoader {
    private static Properties properties = new Properties();

    private PropertiesLoader() {
    } // private constructor

    private static Properties getProperties() {
        String env = System.getProperty("env", "example");
        if (properties.isEmpty()) {
            loadProperties(env);
        }
        return properties;
    }

    private static void loadProperties(String env) {
        String dir = System.getProperty("user.dir");
        Path path = Paths.get(dir, "src", "test", "resources",  String.format("%s.properties", env));
        try (InputStream input = new FileInputStream(path.toString());) {
            properties.load(input);
        } catch (IOException exception) {
            System.out.println();
        }
    }

    public static String get(String key) {
        getProperties();
        String property = properties.getProperty(key);
        if (property == null || property.length() == 0) {
            throw new IllegalArgumentException("Empty property or no property with key " + key);
        }
        return property;
    }

    public static String getSafe(String key) {
        getProperties();
        String property = properties.getProperty(key);
        if (property == null) {
            return "";
        }
        return property;
    }
}
