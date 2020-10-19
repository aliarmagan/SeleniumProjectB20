package com.cybertek.tests.Cybertek_Bitrix;

import com.cybertek.Utilities.BrowserUtility.BrowserUtils;
import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_B220_215 {

    @Test
    public void TC_B220_215(){
        //getting properties from config file:
        String url = ConfigurationReader.getProperty("bitrixUrl");
        String username = ConfigurationReader.getProperty("bitrixUsername");
        String password = ConfigurationReader.getProperty("bitrixPassword");

        //going to url and logging in:
        Driver.getDriver().get(url);
        Driver.getDriver().findElement(By.xpath("//div/input[@name='USER_LOGIN']")).sendKeys(username);
        Driver.getDriver().findElement(By.xpath("//div/input[@name='USER_PASSWORD']")).sendKeys(password + Keys.ENTER);

        //navigating to dashboard:
        Driver.getDriver().findElement(By.xpath("//a[@title = 'Activity Stream']")).click();

        //Navigating to Iframe:
        Driver.getDriver().findElement(By.id("microoPostFormLHE_blogPostForm")).click();

        BrowserUtils.wait(1);

        //locating video input button:
        WebElement videoUploadButton = Driver.getDriver().findElement(By.xpath("//span[@class = 'bxhtmled-top-bar-btn bxhtmled-button-video']"));

        //clicking on video button:
        videoUploadButton.click();

        //locating input for text:
        WebElement textInput = Driver.getDriver().findElement(By.id("video_idPostFormLHE_blogPostForm-source"));

        //sending keys:
        textInput.sendKeys("https://www.youtube.com/watch?v=gGaOMT677TM");

        //finding submit button:
        WebElement submitButton = Driver.getDriver().findElement(By.className("adm-btn-save"));

        //clicking on submit button:
        submitButton.click();


    }

}
