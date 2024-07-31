package com.samson.project.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.util.Properties;

@UtilityClass
public class PropertiesUtil {
    public static final Properties PROPERTIES = new Properties();

    static{
        loadProperties();
    }

    @SneakyThrows
    private static void loadProperties(){
        try (var inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        }
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }
}
