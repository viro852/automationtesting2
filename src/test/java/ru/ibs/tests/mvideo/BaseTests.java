package ru.ibs.tests.mvideo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import ru.ibs.framework.dnsframework.managers.DriverManager;
import ru.ibs.framework.dnsframework.managers.PageManager;
import ru.ibs.framework.mvideoframework.managers.PageManagerMVideo;

import static ru.ibs.framework.mvideoframework.frameworkconsts.Constants.URLS.START_URL;

public class BaseTests {
    WebDriver driver = DriverManager.getDriverManager().getDriver();
    PageManagerMVideo pageManagerMVideo = PageManagerMVideo.getInstance();

    @BeforeEach
    void setUp() {
        driver.get(START_URL);

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
