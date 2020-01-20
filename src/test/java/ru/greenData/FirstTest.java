package ru.greenData;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest extends WebDriverSettings {
    String login="tester";
    String password="K35G3U";
    String fakeLogin="test";
    String fakePassword="1";
    String emptyPassword="";
    String emptyLogin="";


    @Test
    public void firstTest() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("WorkFlow"));
        loginPage.getStarted();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
    }
    @Test
    public void errorAuthTest() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.loginWithLoginButtonCurrent(emptyLogin,emptyPassword);
        loginPage.checkAuthEmptyError();

    }
    @Test
    public void errorAuthTest2() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.loginWithLoginButtonDefault(fakeLogin,fakePassword);
        loginPage.checkAuthWrongError();

    }

}
