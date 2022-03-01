package ru.ibs.framework.mvideoframework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.framework.dnsframework.managers.DriverManager;
import ru.ibs.framework.dnsframework.managers.PageManager;
import ru.ibs.framework.mvideoframework.managers.PageManagerMVideo;

import java.time.Duration;

import static ru.ibs.framework.mvideoframework.frameworkconsts.Constants.Timeouts.EXPLICITLY_WAIT;

public class BasePage {
    protected WebDriver driver = DriverManager.getDriverManager().getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, EXPLICITLY_WAIT);
    protected PageManagerMVideo pageManagerMVideo = PageManagerMVideo.getInstance();

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement waitUntilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void checkPageIsOpened() {
        Assertions.assertEquals(" М.Видео - интернет-магазин цифровой и бытовой техники и электроники, низкие цены, большой каталог, отзывы. ", driver.getTitle());
    }

    public void waitUntilAttributeContains(WebElement element, String productRequest) {
        wait.until(ExpectedConditions.attributeContains(element, "value", productRequest));
    }



}
