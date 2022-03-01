package ru.ibs.framework.mvideoframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ProductListingPage extends BasePage{

    @FindBy(xpath = "//div[@class=\"product-cards-layout__item ng-star-inserted\"]")
    private List<WebElement> productList;


    public void chooseTheRightProduct(String productId) {
        for (WebElement currentElement : productList) {
            if (currentElement.findElement(By.xpath(".//a[@class=\"product-title__text\"]")).getAttribute("href").contains(productId)) {
                currentElement.click();
                return;
            }
        }
    }

}
