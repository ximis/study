package utils;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReadLocations {
    public static Map<String, Map<String, String>> readLocation(String path) {
        System.out.println("用户的当前工作目录:/n"+System.getProperty("user.dir"));

        File file = new File("src/main/java/UIMap" + File.separator +path);

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Map<String, String>> map = new HashMap<>();

        Enumeration KeyValues = prop.keys();
        while (KeyValues.hasMoreElements()) {
            String key = (String) KeyValues.nextElement();
            String value = prop.getProperty(key);
            System.out.println(key + "    " + value);

            String[] data = value.trim().replaceFirst("=", " ").split(" ");
            Map<String, String> values = new HashMap<>();
            values.put("type", data[0]);
            values.put("locator", data[1]);

            map.put(key, values);

        }


        return map;
    }

    public static void main(String[] args){
//        System.out.println("用户的当前工作目录:/n"+System.getProperty("user.dir"));

        readLocation("login.properties");
    }


}
