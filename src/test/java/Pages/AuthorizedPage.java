package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AuthorizedPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public AuthorizedPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private By feedLocator=By.className("feed-stream");

    private String headerString = "Лента - WorkFlow";

    private void checkLoginPageHeader() {
        String title = driver.getTitle();
        Assert.assertEquals(headerString, title);
    }
    public void checkSuccessfulAuth() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(feedLocator));
        checkLoginPageHeader();
    }
}
