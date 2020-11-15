package com.cybertek.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null) {

                String browser = ConfigurationReader.getProperty("browser");

                switch (browser){
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.setHeadless(true);
                        driver = new ChromeDriver(chromeOptions);
                        break;

                    case "firefox":
                        WebDriverManager.chromedriver().setup();
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setHeadless(true);
                        driver = new FirefoxDriver(firefoxOptions);
                        break;

                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        driver.manage().window().maximize();
                        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        break;
                }
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

}
