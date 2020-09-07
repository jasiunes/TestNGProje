package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {
    @Test
    public void dosyaVarMi() {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

          // C:\Users\Muaz\IdeaProjects\TestNGProje
        //  C:\Users\Muaz
        String kullaniciDosyaYolu= System.getProperty("user.dir");
        String pomXmlDosyaYolu= kullaniciDosyaYolu + "/pom.xml";
        boolean varMi = Files.exists(Paths.get(pomXmlDosyaYolu));
        Assert.assertTrue(varMi);
        System.out.println(varMi);
    }
    @Test
    public void dosyaUpload(){
        //bilgisayardan websayfasina dosya yükleme
        driver.get("http://the-internet.herokuapp.com/upload");
        // C:\Users\Muaz\Desktop\Techpro
        //<input id="file-upload" type="file" name="file">
        WebElement dosyaSecmeButonu = driver.findElement(By.id("file-upload"));
        //yüklemek istedigimiz dosyanin ,path(dosya yolunu) ekleyelim.
        dosyaSecmeButonu.sendKeys(" C:\\Users\\Muaz\\Desktop\\Techpro\\logo.png");
        WebElement uploadButonu = driver.findElement(By.id("file-submit"));
        uploadButonu.click();
         WebElement fileUploadedYazisi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedYazisi.isDisplayed());
    }
    @Test
    public void dosyaDownload(){
        WebElement  amsterdamLinki = driver.findElement(By.partialLinkText("Amsterdam.jpg"));
        amsterdamLinki.click();
//<a href="download/Amsterdam.jpg">Amsterdam.jpg</a>

        boolean varMi =Files.exists(Paths.get("C:\\Users\\Muaz\\Downloads"));
        Assert.assertTrue(varMi);

    }
}