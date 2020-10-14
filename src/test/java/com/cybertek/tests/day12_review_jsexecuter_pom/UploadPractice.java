package com.cybertek.tests.day12_review_jsexecuter_pom;

import com.cybertek.Utilities.BrowserUtility.BrowserUtils;
import com.cybertek.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UploadPractice {

    @Test
    public void uploading_file_practice(){

        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        Driver.getDriver().manage().window().maximize();

        String path = "/Users/mohammadafzal/Desktop/Screen Shot 2020-10-06 at 5.13.39 PM.png";

        //Locate the upload web element:
        WebElement uploadInput = Driver.getDriver().findElement(By.id("file-upload"));

        //send the path of file:
        BrowserUtils.wait(3);
        uploadInput.sendKeys(path);

        //locate the upload button:
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));

        //click the upload button:
        BrowserUtils.wait(2);
        uploadButton.click();

    }

}
