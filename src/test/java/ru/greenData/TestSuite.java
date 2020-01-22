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
    @Description("Проверка авторизации по кнопке Войти(другая учетная запись) с пустыми полями")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void f_authDomainWithEmptyFields1() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.loginWithLoginButtonDomain(EMPTY_LOGIN, EMPTY_PASSWORD);
        loginPage.checkAuthEmptyError();
    }

    @Description("Проверка авторизации по кнопке Войти(другая учетная запись) с пустым логином и заполненным паролем")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void g_authDomainWithEmptyFields2() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.loginWithLoginButtonDomain(EMPTY_LOGIN, PASSWORD);
        loginPage.checkAuthEmptyError();
    }
    @Description("Проверка авторизации по кнопке Войти(другая учетная запись) с логином и пустым паролем")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void h_authDomainWithEmptyFields3() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.loginWithLoginButtonDomain(LOGIN, EMPTY_PASSWORD);
        loginPage.checkAuthEmptyError();
    }
    @Description("Проверка авторизации по кнопке Войти(текущая учетная запись) с пустыми полями")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void i_authCurrentWithEmptyFields1() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.loginWithLoginButtonCurrent(EMPTY_LOGIN, EMPTY_PASSWORD);
        loginPage.checkAuthEmptyError();
    }
    @Description("Проверка авторизации по кнопке Войти(текущая учетная запись) с логином и пустым паролем")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void j_authCurrentWithEmptyFields2() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.loginWithLoginButtonCurrent(LOGIN, EMPTY_PASSWORD);
        loginPage.checkAuthEmptyError();
    }
    @Description("Проверка авторизации по кнопке Войти(текущая учетная запись) с пустым логином и заполненным паролем")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void k_authCurrentWithEmptyFields3() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.loginWithLoginButtonCurrent(EMPTY_LOGIN, PASSWORD);
        loginPage.checkAuthEmptyError();
    }
    @Description("Проверка авторизации по внопке Войти с не правильным логином и паролем")
    @Test
    @Severity(SeverityLevel.TRIVIAL)
    public void l_authDefaultWithWrongLoginPassword() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
//        падает, т.к. отображается не правильная ошибка в случае не правильного логина и пароля
        loginPage.loginWithLoginButtonCurrent(FAKE_LOGIN, FAKE_PASSWORD);
        loginPage.checkAuthWrongError();
    }
    @Description("Проверка авторизации по внопке Войти(другая учетная запись) с не правильным логином и паролем")
    @Test
    @Severity(SeverityLevel.TRIVIAL)
    public void m_authDomainWithWrongLoginPassword() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        //        падает, т.к. отображается не правильная ошибка в случае не правильного логина и пароля
        loginPage.loginWithLoginButtonDomain(FAKE_LOGIN, FAKE_PASSWORD);
        loginPage.checkAuthWrongError();
    }
    @Description("Проверка авторизации по внопке Войти(текущая учетная запись) с не правильным логином и паролем")
    @Test
    @Severity(SeverityLevel.TRIVIAL)
    public void n_authCurrentWithWrongLoginPassword() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        //        падает, т.к. отображается не правильная ошибка в случае не правильного логина и пароля
        loginPage.loginWithLoginButtonCurrent(FAKE_LOGIN, FAKE_PASSWORD);
        loginPage.checkAuthWrongError();
    }

    @Description("Проверка авторизации по внопке Войти с не правильным логином и ДЛИННЫМ паролем")
    @Test
    @Severity(SeverityLevel.TRIVIAL)
    public void o_authDefaultWithWrongLoginPassword() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
//        тут правильно сделано, не упадёт
        loginPage.loginWithLoginButtonDefault(LOGIN, FAKE_PASSWORD_LONG);
        loginPage.checkAuthWrongError();
    }
    @Description("Проверка авторизации по внопке Войти(другая учетная запись) с не правильным логином и ДЛИННЫМ паролем")
    @Test
    @Severity(SeverityLevel.TRIVIAL)
    public void p_authDomainWithWrongLoginPassword() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        //        падает, т.к. отображается не правильная ошибка в случае не правильного логина и пароля
        loginPage.loginWithLoginButtonDomain(LOGIN, FAKE_PASSWORD_LONG);
        loginPage.checkAuthWrongError();
    }
    @Description("Проверка авторизации по внопке Войти(текущая учетная запись) с не правильным логином и ДЛИННИМ паролем")
    @Test
    @Severity(SeverityLevel.TRIVIAL)
    public void q_authCurrentWithWrongLoginPassword() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        //        падает, т.к. отображается не правильная ошибка в случае не правильного логина и пароля
        loginPage.loginWithLoginButtonCurrent(LOGIN, FAKE_PASSWORD_LONG);
        loginPage.checkAuthWrongError();
    }

    @Description("Проверка успешной авторизации по кнопке Войти")
    @Test
    @Severity(SeverityLevel.MINOR)
    public void r_authDefaultWithSuccess() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.loginWithLoginButtonDefault(LOGIN, PASSWORD);
        AuthorizedPage authorizedPage = PageFactory.initElements(driver, AuthorizedPage.class);
        authorizedPage.checkSuccessfulAuth();
    }
    @Description("Проверка фейла авторизации по кнопке Войти(другая учетная запись) с дефолтным логином-паролем")
    @Test
    @Severity(SeverityLevel.MINOR)
    public void s_authDomainWithSuccess() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.loginWithLoginButtonDomain(LOGIN, PASSWORD);
        loginPage.checkAuthEmptyError();

    }
    @Description("Проверка фейла авторизации по кнопке Войти(текущая учетная запись) с дефолтным логином-паролем")
    @Test
    @Severity(SeverityLevel.MINOR)
    public void t_authCurrentWithSuccess() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.loginWithLoginButtonCurrent(LOGIN, PASSWORD);
        loginPage.checkAuthEmptyError();
    }
    @Description("Проверка авторизации по кнопке Войти с чекбоксом-запомнить меня")
    @Test
    @Severity(SeverityLevel.MINOR)
    public void u_authDefaultWithSuccessAndRemember() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.makeRememberInput();
        loginPage.loginWithLoginButtonDefault(LOGIN, PASSWORD);
        AuthorizedPage authorizedPage = PageFactory.initElements(driver, AuthorizedPage.class);
        authorizedPage.checkSuccessfulAuth();
    }
    @Description("Проверка авторизации по кнопке Войти(текущая учетная запись) с чекбоксом-запомнить меня")
    @Test
    @Severity(SeverityLevel.MINOR)
    public void v_authDomainWithSuccessAndRemember() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.makeRememberInput();
        loginPage.loginWithLoginButtonDomain(LOGIN, PASSWORD);
        loginPage.checkAuthEmptyError();

    }
    @Description("Проверка авторизации по кнопке Войти(текущая учетная запись) с чекбоксом-запомнить меня")
    @Test
    @Severity(SeverityLevel.MINOR)
    public void w_authCurrentWithSuccessAndRemember() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.makeRememberInput();
        loginPage.loginWithLoginButtonCurrent(LOGIN, PASSWORD);
        loginPage.checkAuthEmptyError();

    }
    @Description("Проверка фейла авторизации по кнопке Войти с чекбоксом-запомнить меня")
    @Test
    @Severity(SeverityLevel.MINOR)
    public void x_authDefaultWithSuccessAndRememberWithReopen() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openAuthPage();
        loginPage.makeRememberInput();
        loginPage.loginWithLoginButtonDefault(LOGIN, PASSWORD);
        AuthorizedPage authorizedPage = PageFactory.initElements(driver, AuthorizedPage.class);
        authorizedPage.checkSuccessfulAuth();
        //откроем ещё одно окно в браузере, чтобы проверить, сработал ли чекбок "запомнить меня"
        //открывается окно авторизации - чекбокс не работает
        loginPage.openAuthPage();
        authorizedPage.checkSuccessfulAuth();
    }


}