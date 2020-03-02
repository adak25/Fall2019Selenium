package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();

        Thread.sleep(3000);

        String title = driver.getTitle();
        String expectedTitle = "Google";
        System.out.println(title);
        if (expectedTitle.equals(title)) {

            System.out.println("Test PASSED");
        }else {
            System.out.println("Test Faild");
        }

        driver.navigate().to("http://amazon.com");

        if (driver.getTitle().toLowerCase().contains("amazon")){

            System.out.println("Test PASSED");
        }else {
            System.out.println("Test Faild");
        }
        driver.close();
    }
    public static void verifyRquals(String arg1, String arg2){
        if (arg1.equals(arg2)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test Faild");
        }

    }
}


