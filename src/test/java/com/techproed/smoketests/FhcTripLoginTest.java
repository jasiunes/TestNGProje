package com.techproed.smoketests;

import com.techproed.pages.FacebookLoginPage;
import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.ConfigurationReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FhcTripLoginTest {
    WebDriver driver;
    @Test
    public void girisTesti(){
        driver.get(ConfigurationReader.getProperty("fhc_login"));
        FhcTripLoginPage loginPage = new FhcTripLoginPage(driver);
    loginPage.userName.sendKeys(ConfigurationReader.getProperty("userName"));
    loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
    loginPage.login.click();
    }
}
