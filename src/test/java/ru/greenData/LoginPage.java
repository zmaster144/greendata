package ru.greenData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(id = "login_button_current")
    private WebElement loginButton2;

    public void open() {
        driver.get("https://gdcloud.ru/release-17/auth/login");
    }
    public void getStarted() {
        loginButton2.click();
    }
}
