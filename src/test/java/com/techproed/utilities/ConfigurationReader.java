package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    /*ConfigurationReader class'ini projemizin heryerinden
    nesne üretmeden, miras almadan kullanabilecek sekilde tasarlayim.
    static:program calisir calismaz, bellekte yer tutmaya yarayan keyword
     */
    static Properties properties;

    static {
        // okumak istediğimiz configuration.properties file'ın dosya yolu
        // C:\Users\isimsiz\IdeaProjects\TestNGProje\configuration.properties
        String path = "configuration.properties";

        try {
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
        } catch (Exception e) {  //dene - hata varsa yakala bu işlemi DENE eğer hata alırsan, PROGRAMI DURDURMA

        }
        //  properties.getProperty("username")  --> manager2
    }public static String getProperty(String key) {
        return properties.getProperty(key);
    }}



