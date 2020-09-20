package com.cybertek.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory_VyTrack {

    public WebDriver driver;
    private String OS = System.getProperty("os.name");
    final private String driverLogin = "user170";
    final private String driverPassword = "UserUser123";

    public static WebDriver getDriver(String browserType){

        if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        } else if (browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        } else {
            System.out.println("Given browser does not exist. Driver = null");
            return null;
        }

    }

    //getter for driver login username:
    public String getDriverLogin(){
        return driverLogin;
    }

    //getter for driver login password:
    public String getDriverPassword(){
        return driverPassword;
    }

    //Take screenshot and set name for ease of re-usability:
    public void getScreenShotMac(String screenShotName) throws IOException {

        //Calling getScreenShotAs method to create new img file:
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //copying file to new location:
        FileUtils.copyFile(srcFile, new File("/Users/mohammadafzal/Desktop/Zain School/" + screenShotName));

    }

    //Take screenshot and set name for ease of re-usability:
    public void getScreenShotWindows(String screenShotName) throws IOException {

        //Calling getScreenShotAs method to create new img file:
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //copying file to new location:
        FileUtils.copyFile(srcFile, new File("C:\\Users\\Zain\\Desktop\\B20 Automation Class\\Selenium Assignments\\Screenshots\\" + screenShotName));

    }

    public void setDriver(){
        driver = WebDriverFactory_VyTrack.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Go to QA environment VyTrack:
        driver.get("https://qa2.vytrack.com");

    }

    public void driverTearDown() {
        //Halting execution of code to see page results:
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //Closing driver after every test:
        driver.close();

    }

    public String getOS(){
        return OS;
    }

    public void getOSAndScreenShot(String screenShotName) throws IOException {

        if (getOS().toLowerCase().contains("windows")){
            getScreenShotWindows(screenShotName);
        }

        if (getOS().toLowerCase().contains("mac")){
           getScreenShotMac(screenShotName);
        }

    }

}
