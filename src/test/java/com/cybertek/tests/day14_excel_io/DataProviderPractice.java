package com.cybertek.tests.day14_excel_io;

import com.cybertek.Utilities.Driver;
import com.cybertek.Utilities.ExcelUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

    @FindBy(id = "prependedInput")
    private WebElement usernameElement;

    @FindBy(id = "prependedInput2")
    private WebElement passwordElement;

    @Test(dataProvider = "userTestData")
    public void ddtLoginTest1(String execute, String username, String password, String firstname, String lastname){
        System.out.println("User name is: " + firstname + " " + lastname + ", execute ?" + execute);
        if (execute.equals("y")) {
            usernameElement.sendKeys(username);
            passwordElement.sendKeys(password, Keys.ENTER);
        } else {
            throw new SkipException("Test was skipped!");
        }
    }

    @DataProvider
    public Object[][] userTestData(){
        ExcelUtil excelUtil = new ExcelUtil("vytrack_testusers.xlsx", "QA3-short");
        return excelUtil.getDataArray();
        };

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://qa1.vytrack.com/user/login");
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
