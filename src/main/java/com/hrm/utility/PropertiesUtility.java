package com.hrm.utility;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.util.Properties;

public class PropertiesUtility {
    public static String getData(String key) throws IOException{
    File file=new File("src/test/java/com/hrm/resources/testdata.properties");
    FileReader reader=new FileReader(file);
    Properties properties=new Properties();
    properties.load(reader);
    return (String) properties.get(key);
}
}
