package ru.greenData;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/zm/Downloads/test_greendata_project/src/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.delivery-club.ru/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Delivery club"));
        driver.quit();
    }
}
