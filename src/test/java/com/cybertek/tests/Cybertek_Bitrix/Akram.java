package com.cybertek.tests.Cybertek_Bitrix;

import com.cybertek.Utilities.BrowserUtility.BrowserUtils;
import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Akram {

    @BeforeMethod
    public void login(){
        String url = ConfigurationReader.getProperty("bitrixUrl");
        String username = ConfigurationReader.getProperty("bitrixUsername");
        String password = ConfigurationReader.getProperty("bitrixPassword");

        Driver.getDriver().get(url);

        //going to url and logging in:
        Driver.getDriver().get(url);
        Driver.getDriver().findElement(By.xpath("//div/input[@name='USER_LOGIN']")).sendKeys(username);
        Driver.getDriver().findElement(By.xpath("//div/input[@name='USER_PASSWORD']")).sendKeys(password + Keys.ENTER);

        //navigate to stream:
        Driver.getDriver().findElement(By.xpath("//a[@title = 'Activity Stream']")).click();

    }

    @Test
    public void task(){

        //navigate to task:
        Driver.getDriver().findElement(By.id("feed-add-post-form-tab-tasks")).click();

        //waiting for browser to load task bar:
        BrowserUtils.wait(2);

        //get task text bar:
        WebElement taskTextBar = Driver.getDriver().findElement(By.name("ACTION[0][ARGUMENTS][data][TITLE]"));

        //send keys to task bar:
        taskTextBar.sendKeys("Hello");

        //locating iframe under task text bar:
        WebElement textFrame = Driver.getDriver().findElement(By.xpath("(//div/iframe[@class = 'bx-editor-iframe'])[1]"));

        //switching from default content to iframe:
        Driver.getDriver().switchTo().frame(textFrame);

        //locating text bar and sending keys:
        WebElement iframeText = Driver.getDriver().findElement(By.xpath("//html/body"));
        iframeText.click();
        iframeText.sendKeys("hello");


        //switching to driver to default content:
        Driver.getDriver().switchTo().parentFrame();

        //locating and clicking send button:
        WebElement send = Driver.getDriver().findElement(By.id("xblog-submit-button-save"));

    }

}
