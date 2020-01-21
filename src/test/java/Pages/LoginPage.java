package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private String errorMsgEmptyFields ="Аутентификация не удалась";
    private String errorMsgWrongFields ="Неверное имя пользователя или пароль";
    private String headerString = "WorkFlow";
    private String textLoginField ="Номер телефона или E-mail";
    private String textPasswordField="Пароль";

    @FindBy(id = "login_button")
    private WebElement loginButtonDefault;

    @FindBy(id = "login_button_domain")
    private  WebElement loginButtonDomain;

    @FindBy(id = "login_button_current")
    private WebElement loginButtonCurrent;

    @FindBy(id ="error")
    private WebElement error;

    @FindBy(id = "remember")
    private WebElement remember;

    @FindBy(id ="username")
    private WebElement usernameField;

    @FindBy(id= "password")
    private WebElement passwordField;

    private By errorMsgLocator = By.id("error");


    public void open() {
        driver.get("https://gdcloud.ru/release-17/auth/login");
    }
    private void authorization(String login, String password) {
        usernameField.sendKeys(login);
        passwordField.sendKeys(password);
    }
    public void loginWithLoginButtonDefault(String login, String password) {
        authorization(login,password);
        loginButtonDefault.click();

    }
    public void loginWithLoginButtonDomain(String login, String password) {
        usernameField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButtonDomain.click();
    }
    public void loginWithLoginButtonCurrent(String login, String password) {
        usernameField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButtonCurrent.click();
    }
    private void checkErrorMsg(String errorCheck){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgLocator));
        String emptyFieldsError= error.getText();
        Assert.assertEquals(emptyFieldsError,errorCheck);
        error.isEnabled();
        error.isDisplayed();
    }

    public void checkAuthEmptyError() {
        checkErrorMsg(errorMsgEmptyFields);
    }
    public void checkAuthWrongError() {
        checkErrorMsg(errorMsgWrongFields);
    }
    public void checkLoginPageHeader() {
        String title = driver.getTitle();
        Assert.assertEquals(headerString, title);
    }
    public void checkLoginPageElements() {
        Assert.assertEquals(usernameField.getAttribute("placeholder"),textLoginField);
        Assert.assertEquals(passwordField.getAttribute("placeholder"),textPasswordField);

    }

}
