package com.techproed.tests;

import com.techproed.pages.GoogleAramaPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//TestBaseFinali extends ediyoruz orada rapor almak istedigimiz nesneler ve methodlar var.
public class GoogleAramaTest extends TestBaseFinal {
    /*
    1-Google git
    2-Techproed ara
    3-sonuclar icerisinde techproed var mi dogrula
     */
    @Test
    public void aramaTesti() throws InterruptedException {
        extentTest  = extentReports.createTest("Google Arama","Google'da techproeducation araması yaptık.");
        extentTest.info("Sayfa adresine git.");
        Driver.getDriver().get(ConfigurationReader.getProperty("google_link"));
        extentTest.info("Webelementleri kullanabilmek için nesne oluştur.");
        GoogleAramaPage googleAramaPage = new GoogleAramaPage();
        extentTest.info("techproeducation araması yap.");
        googleAramaPage.aramaKutusu.sendKeys("techproeducation" + Keys.ENTER);
        extentTest.info("3 saniye bekle.");
        Thread.sleep(4000);
        extentTest.info("Tüm linkleri karşılaştır.");
        boolean linkVarMi = false;
        for(WebElement w : googleAramaPage.tumLinkler){
            if(w.getText().contains("techproeducation.com")){
                linkVarMi = true;
                break;
            }
        }
        extentTest.info("Assert işlemi yap.");
        Assert.assertTrue(linkVarMi);
        extentTest.pass("Testimiz PASSED !");
   }
    }


