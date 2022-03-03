package ru.ibs.framework.dnsframework.utils;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.ibs.framework.dnsframework.managers.DriverManager;

public class ScreenShotExtension implements TestWatcher {
    WebDriver driver = DriverManager.getDriverManager().getDriver();

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] getScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        getScreenShot();
    }
}

