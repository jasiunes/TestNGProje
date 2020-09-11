package com.techproed.smoketests;

import com.techproed.pages.FacebookLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FacebookLoginTest extends TestBase {
    @Test
    public void girisTesti(){
        driver.get("http://facebook.com");
        FacebookLoginPage loginPage = new FacebookLoginPage(driver);
        loginPage.mailBox.sendKeys(ConfigurationReader.getProperty("fb_mail"));
        loginPage.passBox.sendKeys(ConfigurationReader.getProperty("fb_pass"));

    }
}
