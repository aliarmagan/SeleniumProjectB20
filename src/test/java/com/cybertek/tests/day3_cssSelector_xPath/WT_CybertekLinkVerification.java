package com.cybertek.tests.day3_cssSelector_xPath;

import com.cybertek.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WT_CybertekLinkVerification {

    public static void main(String[] args) {

        // TC #3: PracticeCybertek/ForgotPassword URL verification
        // 1.Open Chrome browser:
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        //Using custom method in Utilities, Easier to make changes and it can be reusable many times:
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2.Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // 3.Enter any email into input box
        driver.findElement(By.name("email")).sendKeys("zainafzalb@gmail.com");

        // 4.Click on Retrieve password
        driver.findElement(By.className("radius")).click();

        // 5.Verify URL contains: Expected: “email_sent”
        String expectedURL = "http://practice.cybertekschool.com/email_sent";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedURL)){
            System.out.println("URL test successful");
        } else {
            System.out.println("URL test failed");
        }

        // 6.Verify text box displayed the content as expected.
        // Expected: “Your e-mail’s been sent!”
        String expectedText = "Your e-mail's been sent!";

        //Getting the actual text of the tag
        String actualText = driver.findElement(By.name("confirmation_message")).getText();

        //Testing the text against expected result:
        if (actualText.equals(expectedText)){
            System.out.println("Text verification successful!");
        } else {
            System.out.println("Text verification failed!");
        }

    }

}
