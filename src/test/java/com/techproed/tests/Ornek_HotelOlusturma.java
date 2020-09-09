package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ornek_HotelOlusturma extends TestBase {
    @BeforeMethod
    public void giris(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }
    @Test
    public void hotelCreate(){
        WebElement codeKutusu = driver.findElement(By.id("Code"));
        WebElement nameKutusu = driver.findElement(By.id("Name"));
        WebElement adresKutusu= driver.findElement(By.id("Address"));
        WebElement phoneKutusu= driver.findElement(By.id("Phone"));
        WebElement emailKutusu= driver.findElement(By.id("Email"));
        WebElement idGrup     = driver.findElement(By.id("IDGroup"));
        WebElement saveButonu = driver.findElement(By.id("btnSubmit"));
        codeKutusu.sendKeys("1234");
        nameKutusu.sendKeys("Arya Unes");
        adresKutusu.sendKeys("Müller St. 10/20");
        phoneKutusu.sendKeys("015266074163");
        emailKutusu.sendKeys("arya@dunyam.com");

        Select select = new Select(idGrup);
        select.selectByIndex(2);
        saveButonu.click();
        // WebElement basariliYazisi = driver.findElement(By.className("bootbox-body"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement basariliYazisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        Assert.assertTrue(basariliYazisi.isDisplayed());
    }
}