package com.cybertek.tests.day10_testBase_DriverUtil;

import com.cybertek.Utilities.BrowserUtility.SmartBearUtilities;
import com.cybertek.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class SmartBearPractices_9_10_11 extends TestBase {

   /* @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SmartBearUtilities.loginToSmartBear(driver);

    }*/

    @Test
    public void p9_delete_order_task() throws IOException {
        //Creating properties object to be able to read properties file
        Properties properties = new Properties();

        //Opening the file in JVM memory using FileInputStream
        FileInputStream file = new FileInputStream("configuration.properties");

        //loading the file into properties object
        properties.load(file);

        // -> Getting Url from configurations file and
        String url = properties.getProperty("smartBearUrl");

        //getting the url
        driver.get(url);

        //logging in to smartBear using smartBearUtilities class:
        SmartBearUtilities.loginToSmartBear(driver);

        //Locate the checkbox for mark smith and click on it
        WebElement markSmithCheckbox = driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]"));

        //click on the check box
        markSmithCheckbox.click();

        //find delete button and click on it
        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println(e);
        }

        //click on it
        deleteButton.click();

        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        //Assert false works in a way that driver would check the whole list before failing the test
        //Assert true is not used here because it would only check the first element and fail the test instead of going through the whole list of elements
        for (WebElement each : namesList) {
            Assert.assertFalse(each.getText().equals("Mark Smith"));
        }


    }

}
