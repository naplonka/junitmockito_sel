package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium {
    WebDriver driver;
    private ChromeOptions initialize() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("logLevel", "INFO");
        options.setCapability("browserAttachTimeout", 1000);
        return options;
    }
    public WebDriver getDriver() {
        ChromeOptions options = initialize();
            driver = new ChromeDriver(options);
        return driver;
    }

    @Test
    public void seleniumTest() {
        getDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("test");
    }

}
