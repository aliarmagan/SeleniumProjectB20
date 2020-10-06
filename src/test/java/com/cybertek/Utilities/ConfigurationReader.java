package com.cybertek.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //#1- We created the properties object
    private static Properties properties = new Properties();

    //We are using static block because we are typing code outside of a method,
    //Without static block we cannot type code outside a method!

    static {
        //to handle the exception FileInputStream is throwing, we are surrounding it with try-catch

        try {
            //#2- We get the path and pass it into FileInput Stream, to open the file
            FileInputStream file = new FileInputStream("configuration.properties");

            //#3- We load the opened file into properties object
            properties.load(file);

            //#5- Close the file
            file.close();

        } catch (IOException e) {
            System.out.println("Properties not found");
        }

    }

    //#4- we read the file: we will be creating a utility method for reading.
    public static String getProperty (String keyword){
        return properties.getProperty(keyword);
    }

}
