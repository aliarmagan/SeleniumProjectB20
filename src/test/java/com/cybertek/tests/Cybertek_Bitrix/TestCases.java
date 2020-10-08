package com.cybertek.tests.Cybertek_Bitrix;

import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.Properties;

public class TestCases {

    //B220-176 AC# 2
    //TC B220-215

    @Test
    public void TC_B220_215(){
        //getting properties from config file:
        String url = ConfigurationReader.getProperty("bitrixUrl");
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");

        //going to url and logging in:
        Driver.getDriver().get(url);
        Driver.getDriver().findElement(By.xpath("//div/input[@name='USER_LOGIN']")).sendKeys(username);
        Driver.getDriver().findElement(By.xpath("//div/input[@name='USER_PASSWORD']")).sendKeys(password + Keys.ENTER);

        //navigating to dashboard:
        Driver.getDriver().findElement(By.xpath("//a[@title = 'Activity Stream']")).click();

        //Navigating to Iframe:
        Driver.getDriver().findElement(By.id("microoPostFormLHE_blogPostForm")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println("e");
        }

        //navigating to text editor:
        WebElement textEditorButton = Driver.getDriver().findElement(By.xpath("//div/span[@class='feed-add-post-form-editor-btn']"));

        //clicking on button to activate text editor:
        textEditorButton.click();

        //locating text editor and asserting its displayed:
        WebElement textEditor = Driver.getDriver().findElement(By.id("bx-html-editor-tlbr-cnt-idPostFormLHE_blogPostForm"));

        Assert.assertTrue(textEditor.isDisplayed(), "Text-editor is not displayed!");

        //closing the driver:
       // Driver.getDriver().close();




    }

}
