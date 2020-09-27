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

        List<String> elementText = new ArrayList<>();

        for (WebElement eachElement : list) {
               elementText.add(eachElement.getText());
        }

        return elementText;

    }

}
