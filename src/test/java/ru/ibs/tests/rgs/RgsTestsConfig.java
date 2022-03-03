package ru.ibs.tests.rgs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RgsTestsConfig {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeAll
    static void beforeAll() {

    }

    @BeforeEach
    void setUp() {
        System.out.println("устанавливается системаня переменная");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\chromedriver.exe");
        System.out.println("инициализируется драйвер");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
        System.out.println("переходим на главную страницу сайта");
        driver.navigate().to("https://rgs.ru/");
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {

    driver.quit();
}


    @AfterAll
    static void afterAll() {

    }
}
