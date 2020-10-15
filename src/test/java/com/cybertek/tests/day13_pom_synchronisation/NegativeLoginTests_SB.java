package com.cybertek.tests.day13_pom_synchronisation;

import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.Driver;
import com.cybertek.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests_SB {

    LoginPage loginPage;

    @Test(description = "entering incorrect username")
    public void negative_login_test(){

        String url = ConfigurationReader.getProperty("smartBearUrl");
        Driver.getDriver().get(url);

        //Lets start using page object model:
        //When we create the instance of this class, the constructor
        //immediately initializes our diver and the object 'LoginPage'

        //#1 - we need to create the object of the class we want to use:
        loginPage = new LoginPage();

        //#2 - Call the object to use the web elements:
        //entering incorrect username:
        loginPage.usernameInput.sendKeys("assdf");

        //enter the correct password:
        String password = ConfigurationReader.getProperty("smartBear_Password");
        loginPage.passwordInput.sendKeys(password);

        //Click on the login button:
        loginPage.loginButton.click();

        //assert true that error message is displayed:
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed. Verification failed!");

    }

    @Test (description = "using login method for negative test")
    public void negative_login_test2(){

        String url = ConfigurationReader.getProperty("smartBearUrl");
        Driver.getDriver().get(url);

        //re-instantiating object to avoid issues:
        loginPage = new LoginPage();

        String username = "asdfas";
        String password = ConfigurationReader.getProperty("smartBear_Password");

        loginPage.login(username, password);

    }

}
