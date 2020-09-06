package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ornek_AmazonKayitSayfasi extends TestBase { //Day14-06 Eylül 2020 Pazar
    @Test
    public void test01() {
        driver.get("http:///amazon.com");
        WebElement buton = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(buton).perform();

        WebElement startHere = driver.findElement(By.partialLinkText("Start here."));
        startHere.click();

        String sayfaTitle = driver.getTitle();
        System.out.println(sayfaTitle);
        Assert.assertEquals("Amazon Registration", sayfaTitle);
    }

    @Test (dependsOnMethods = "test01")
    public void test2() {
        driver.get("http://amazon.com");
        WebElement box=driver.findElement(By.id("nav-link-accountList"));
        Actions actions=new Actions(driver);
        actions.moveToElement(box).perform();

        WebElement startHere = driver.findElement(By.partialLinkText("Start here"));
        startHere.click();

        WebElement nameBox=driver.findElement(By.id("ap_customer_name"));
        nameBox.sendKeys("Yasemin EMEC");
        WebElement emailBox=driver.findElement(By.id("ap_email"));
        emailBox.sendKeys("emecyasemin@hotmail.com");
        WebElement passwordBox=driver.findElement(By.name("password"));
        passwordBox.sendKeys("jasi1288jasi");
        WebElement passwordBox2=driver.findElement(By.id("ap_password_check"));
        passwordBox2.sendKeys("jasi1288jasi");
        WebElement createBox=driver.findElement(By.id("continue"));
        createBox.click();
    }
}