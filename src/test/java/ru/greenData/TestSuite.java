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

    @Description("Тест для проверки скриншота")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void a_makeScreenshot() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.loginWithLoginButtonDefault(FAKE_LOGIN, FAKE_PASSWORD);
        AuthorizedPage authorizedPage = PageFactory.initElements(driver, AuthorizedPage.class);
        //здесь он упадёт
        authorizedPage.checkSuccessfulAuth();
    }

    @Description("Проверка элементов страницы авторизации")
    @Test
    @Severity(SeverityLevel.MINOR)
    public void b_inspectLoginPageElements() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.checkLoginPageElements();
    }

    @Description("Проверка авторизации по кнопке Войти с пустыми полями")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void c_authDefaultWithEmptyFields1() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.loginWithLoginButtonDefault(EMPTY_LOGIN, EMPTY_PASSWORD);
        //здесь он упадёт т.к. поле логин required и нажатие на кнопку с этими полями не бросает ошибок
        loginPage.checkAuthEmptyError();
    }

    @Description("Проверка авторизации по кнопке Войти с пустыми логином и заполненым паролем")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void d_authDefaultWithEmptyFields2() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.loginWithLoginButtonDefault(EMPTY_LOGIN, PASSWORD);
        //здесь он упадёт т.к. поле логин required и нажатие на кнопку с этими полями не бросает ошибок
        loginPage.checkAuthEmptyError();
    }

    @Description("Проверка авторизации по кнопке Войти с пустыми логином и заполненым паролем")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void e_authDefaultWithEmptyFields3() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.loginWithLoginButtonDefault(LOGIN, EMPTY_PASSWORD);
        //здесь он упадёт т.к. поле логин required и нажатие на кнопку с этими полями не бросает ошибок
        loginPage.checkAuthEmptyError();
    }
}