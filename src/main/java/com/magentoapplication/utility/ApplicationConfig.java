package com.magentoapplication.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationConfig {

    public static String readFromConfigProperties(String fileName,String key){
        Properties properties=new Properties();
        String value;
        try {
            properties.load(new FileInputStream(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        value=properties.getProperty(key);
        System.out.println(String.format("%s = %s",key,value));
        return value;
    }
}
