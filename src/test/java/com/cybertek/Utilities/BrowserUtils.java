package com.cybertek.Utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /**
    Accepts a list of Web Element
    @param list
    @return List<String>
    Method should be returning a list of Strings
     */

    public static List<String> getElementText(List<WebElement> list){

        List<String> elementTextOptions = new ArrayList<>();

        for (WebElement eachElement : list) {
               elementTextOptions.add(eachElement.getText());
        }

        return elementTextOptions;

    }

    /**
    Create a utility method name: wait
    static method
    @param sec
    @return void
     Integer num i pass should be accepted as seconds
     Handle checked exception with try-catch
     */

    public static void wait(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }



}
