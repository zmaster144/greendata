package ru.greenData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebDriverSettings extends TestsConfigurator {
    public WebDriver driver;
    public WebDriverWait wait;

    private void initDriver(String browser) {
        if ("Chrome".equals(browser)) {
            System.setProperty("webdriver.chrome.driver",
                    CHROME_PATH);
            driver = new ChromeDriver();
        } else if ("Firefox".equals(browser)) {
            System.setProperty("webdriver.gecko.driver",
                    FIREFOX_PATH);
            driver = new FirefoxDriver();
        } else if ("Safari".equals(browser)) {
            System.setProperty("webdriver.safari.driver",
                    SAFARI_PATH);
            driver = new SafariDriver();
        } else {
            System.out.println("Invalid Browser!!!");
        }
        driver.manage().deleteAllCookies();

    }
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        initDriver(BROWSER);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public void shutDownDriver() {
        driver.quit();
    }
}
