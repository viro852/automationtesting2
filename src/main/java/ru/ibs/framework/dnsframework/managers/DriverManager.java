package ru.ibs.framework.dnsframework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static DriverManager driverManager;
    private WebDriver driver;

    private DriverManager() {

    }

    public static DriverManager getDriverManager() {
        if(driverManager==null){
            driverManager=new DriverManager();
        }
        return driverManager;
    }

    public WebDriver getDriver() {
        if(driver==null){
            initWebDriver();
        }
        return driver;
    }

    private void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
