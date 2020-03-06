package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle);

        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandles);
        System.out.println("BEFORE SWITCH :" +driver.getCurrentUrl());

        for (String windowId : windowHandles){

            if (!windowId.equals(windowHandle)) {
                driver.switchTo().window(windowId);

            }

        }
        System.out.println("AFTER SWITCH :" +driver.getCurrentUrl());

        //switchToWindowBasedOnTitle();

        //driver.close();
        driver.quit();

    }

    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> window = driver.getWindowHandles();
        for (String windows : window){
            driver.switchTo().window(windows);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }
}

