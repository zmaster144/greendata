package ru.greenData;

import Pages.AuthorizedPage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestListener;

@Listeners({ TestListener.class })
public class TestSuite extends WebDriverSettings {
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
        loginPage.loginWithLoginButtonCurrent(EMPTY_LOGIN, EMPTY_PASSWORD);
        loginPage.checkAuthEmptyError();

    }
    @Test
    public void errorAuthTest2() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.loginWithLoginButtonDefault(FAKE_LOGIN, FAKE_PASSWORD);
        loginPage.checkAuthWrongError();

    }
    @Description
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void successLogin() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.loginWithLoginButtonDefault(LOGIN, PASSWORD);
        AuthorizedPage authorizedPage = PageFactory.initElements(driver, AuthorizedPage.class);
        authorizedPage.checkSuccessfulAuth();
    }

}
