package ru.ibs.framework.mvideoframework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.ibs.framework.mvideoframework.frameworkconsts.Constants;

import java.util.concurrent.TimeUnit;

import static ru.ibs.framework.mvideoframework.frameworkconsts.Constants.Timeouts.*;

/**
 * Класс DriverManager ответственен за поставку для нас WebDriver от Selenium,
 * данный класс делаем singleton(порождающий паттерн),чтобы больше никто не мог создать объект этого класса
 */
public class DriverManager {

    static DriverManager driverManager;
    private WebDriver driver;

    private DriverManager() {

    }

    public static DriverManager getInstance() {
         if (driverManager == null) {
             driverManager = new DriverManager();
         }
        return driverManager;
    }

    private WebDriver getWebDriver() {
        if (driver == null) {
            initWebdriver();
        }
        return driver;
    }

    private void initWebdriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
    }
}
