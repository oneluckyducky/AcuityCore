package com.acuity.db.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Zachary Herridge on 8/1/2017.
 */
public class DBAccess {

    public static String getUsername(){
        return getProperty("arangodb.user");
    }

    public static String getPassword(){
        return getProperty("arangodb.password");
    }

    private static String getProperty(String key){
        Properties prop = new Properties();
        try (InputStream in = DBAccess.class.getClassLoader().getResourceAsStream("db.properties")){
            prop.load(in);
            return prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
