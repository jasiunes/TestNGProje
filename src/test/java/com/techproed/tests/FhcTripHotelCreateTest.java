package com.techproed.tests;

import com.techproed.pages.FhcTripHotelCreatePage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FhcTripHotelCreateTest extends TestBase {
    public void giris(){
        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ 	Keys.ENTER);
    }
    @Test
    public void test(){
        giris();
        FhcTripHotelCreatePage fhcTripHotelCreatePage= new FhcTripHotelCreatePage(driver);
        fhcTripHotelCreatePage.codeBox.sendKeys();
        fhcTripHotelCreatePage.addressBox.sendKeys();
        fhcTripHotelCreatePage.emailBox.sendKeys();
        fhcTripHotelCreatePage.nameBox.sendKeys();
        fhcTripHotelCreatePage.phoneBox.sendKeys();
        Select select=new Select(fhcTripHotelCreatePage.idgroupBox);
        select.selectByIndex(2);
        fhcTripHotelCreatePage.submit.click();
    }
}
