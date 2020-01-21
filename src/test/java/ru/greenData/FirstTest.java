package ru.greenData;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestListener;

@Listeners({ TestListener.class })
public class FirstTest extends WebDriverSettings {
    @Test
    public void firstTest() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.checkLoginPageHeader();
        loginPage.checkLoginPageElements();
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
    @Description
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void successLogin() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
//        loginPage.loginWithLoginButtonDefault(login,password);
        AuthorizedPage authorizedPage = PageFactory.initElements(driver, AuthorizedPage.class);
        authorizedPage.checkSuccessfulAuth();
    }

}
