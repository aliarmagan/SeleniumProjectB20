package com.cybertek.tests.day1_SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        //1- set up web driver:
        WebDriverManager.chromedriver().setup();

        //2- create the instance of chrome driver:
        WebDriver driver = new ChromeDriver();

        //.manage().window().maximize(): this will maxmize the size of the window opened.
        driver.manage().window().maximize();

        //3- test if driver is working:
        driver.get("https://google.com");

        //.getTitle: Gets the title of the page selenium lands on.
        //System.out.println("The title of the page is: " + driver.getTitle());
        String actualTitle = driver.getTitle();
        System.out.println("Actual title: " + actualTitle);

        //.getCurrentUrl: gets the current url the page is on
        String actualUrl = driver.getCurrentUrl();
        System.out.println("ActualUrl = " + actualUrl);

        //thread.sleep: pauses the execution of code for a set amount of time
        Thread.sleep(2000);

        //.navigate (.back): this navigates the page back once, this is simple navigation
        driver.navigate().back();

        Thread.sleep(2000);

        //.navigate (.forward): this navigates the page forward, simple nav
        driver.navigate().forward();

        Thread.sleep(2000);

        //.navigate (.refresh): this just refreshes whatever is on the page, simple nav action
        driver.navigate().refresh();

        Thread.sleep(2000);

        //.navigate (.to("https://examle.com")): this navigates to the given url exactly the same as .get method(waits for page to load completely while .to method doesn't)
        driver.navigate().to("https://www.facebook.com");

        //.getPageSource: gets the page source we are on
        driver.getPageSource();

        //.close: this will close the driver (Only closes last open window of browser).
        driver.close();

        //.quit: this will close all of the browsers in this session


    }

}
