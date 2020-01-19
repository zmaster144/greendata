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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest extends WebDriverSettings {


    @Test
    public void firstTest() {
        driver.get("https://gdcloud.ru/release-17/auth/login");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("WorkFlow"));
        WebElement loginButton = driver.findElement(By.id("login_button_current"));
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
    }
}
