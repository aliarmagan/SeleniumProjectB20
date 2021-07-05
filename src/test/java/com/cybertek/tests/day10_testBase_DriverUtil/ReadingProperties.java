package com.cybertek.tests.day10_testBase_DriverUtil;

import com.cybertek.Utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_file() throws Exception {

        //Properties: Use properties class object
        //We create properties object to be able to read configuration.properties file
        Properties properties = new Properties();

        //FileInput Stream:
        String path = "configuration.properties";

        //We need to pass the path of the file we want to open in JVM
        FileInputStream file  = new FileInputStream(path);

        //We will load the file
        properties.load(file);

        //We will read from the file
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
        System.out.println("properties.getProperty(\"smartBearUrl\") = " + properties.getProperty("smartBearUrl"));

        //close the file
        file.close();


    }

    @Test
    public void using_properties_utility_method(){
        //This will read the given "keys's" value and return it
        //as a string
        System.out.println("ConfigurationReader.getProperty(\"browser\") = " + ConfigurationReader.getProperty("browser"));
        System.out.println("ConfigurationReader.getProperty(\"username\") = " + ConfigurationReader.getProperty("username"));
        System.out.println("ConfigurationReader.getProperty(\"smartBearUrl\") = " + ConfigurationReader.getProperty("smartBearUrl"));
    }

}
