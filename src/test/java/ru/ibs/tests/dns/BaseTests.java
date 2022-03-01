package ru.ibs.tests.dns;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.ibs.framework.dnsframework.managers.DriverManager;
import ru.ibs.framework.dnsframework.managers.PageManager;
import ru.ibs.framework.dnsframework.managers.PropManager;

public class BaseTests {

    DriverManager driverManager = DriverManager.getDriverManager();
    PropManager propManager=PropManager.getPropManager();
    PageManager pageManager = PageManager.getPageManager();

    @BeforeEach
    public void setUp() {
        driverManager.getDriver().get("https://www.dns-shop.ru/");
    }

    @AfterEach
    void tearDown() {
        driverManager.getDriver().quit();
    }
}
