package com.cybertek.tests.day12_review_jsexecuter_pom;

import com.cybertek.Utilities.BrowserUtility.BrowserUtils;
import com.cybertek.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutor_Practices {

    @Test
    public void scroll_using_jsExecutor_1(){
        //Get the page to scroll:
        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");

        //create instance of JSExecutor and cast our driver type to it:
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //use execute script method:
        for (int i = 0; i < 10; i++) {
            BrowserUtils.wait(1);
            js.executeScript("window.scrollBy(0, 1000)");
        }

    }

    @Test
    public void scroll_using_jsExecutor(){
        //get the page to scroll:
        Driver.getDriver().get("http://practice.cybertekschool.com/large");


        //locating cybertek school link:
        WebElement link = Driver.getDriver().findElement(By.linkText("Cybertek School"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));

        //use js Executor to scroll 'Cybertek school' link into view:
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //use scroll into view function from JavaScript to scroll to a specific web element:
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].scrollIntoView(true)", link);
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].scrollIntoView(true)", homeLink);

    }

}
