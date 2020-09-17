package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;

public class Driver {
    // WebDriver nesnemizi, static olarak oluşturduk, çünkü program başlar başlamaz
// hafızada yer almasını istiyoruz.
   static WebDriver driver;
public static WebDriver getDriver(){
/*Programin herhangi bir yerinden getDriver()
methodu cagirilarakhafiza Static olarak olusturulmus Driver nesnesine erisebiliriz.
 Yani yeniden WebDriver*/
if (driver == null){
   switch ("chrome"){
       case"chrome":
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
           break;
       case "firefox":
           WebDriverManager.firefoxdriver().setup();
           driver = new FirefoxDriver();
           break;
       case "ie":
           WebDriverManager.iedriver().setup();
           driver = new InternetExplorerDriver();
           break;
       case "safari":
           WebDriverManager.getInstance(SafariDriver.class).setup();
           driver = new SafariDriver();
           break;
       case "headless-chrome":
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
           break;
   }
}
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.manage().window().maximize();
    return driver;
}
public static void closeDriver(){
    //Eger driver nesnesi Null degilse, yani hafızada varsa
    if(driver != null){
        driver.quit();
        driver = null;//driver'i hafizadan temizle
    }
}
}