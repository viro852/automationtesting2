package ru.ibs.framework.mvideoframework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StartPage extends BasePage {

    @FindBy(xpath = "//input[@class=\"input__field\"]")
    WebElement searchLine;

    @FindBy(xpath = "//input[@class=\"input__field input__field--clearable\"]")
    WebElement searchLineActive;






    public ProductListingPage typeRequestToSearchLineButtonAndEnter(String productRequest) {
        waitUntilElementToBeClickable(searchLine).click();
        searchLine.clear();
        searchLine.sendKeys(productRequest);
        waitUntilAttributeContains(searchLineActive, productRequest);
        searchLineActive.sendKeys(Keys.ENTER);

        return pageManagerMVideo.getProductListingPagePage();
    }
}
