package com.cybertek.tests.day11_utils_review_actions;

import com.cybertek.Utilities.BrowserUtility.BrowserUtils;
import com.cybertek.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPractice {

    @Test
    public void hover_over_test(){
        //TC #15: Hover Test
        //1. Go to http://practice.cybertekschool.com/hovers
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        //locating images to hover over:
        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[3]"));

        WebElement user1 = Driver.getDriver().findElement(By.xpath("//div/h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//div/h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//div/h5[.='name: user3']"));

        //2. Hover over to first image:
        //Create the instance of the Actions class, and pass the driver instance into the constructor:
        Actions actions = new Actions(Driver.getDriver());

        //Use Actions object, and call necessary methods
        //3. Assert:
        //a. "name: user1" is displayed
        BrowserUtils.wait(2);
        actions.moveToElement(img1).perform();
        Assert.assertTrue(user1.isDisplayed(), "Image 1 is not displayed! Verification failed!!!");

        //4. Hover over to second image
        BrowserUtils.wait(2);
        actions.moveToElement(img2).perform();

        //5. Assert:
        //a. "name: user2" is displayed
        Assert.assertTrue(user2.isDisplayed(), "Image 2 is not displayed! Verification failed!!!");

        //6. Hover over to third image
        BrowserUtils.wait(2);
        actions.moveToElement(img3).perform();

        //7. Confirm:
        //a. "name: user3" is displayed
        Assert.assertTrue(user3.isDisplayed(), "Image 3 is not displayed! Verification failed!!!");


    }

}
