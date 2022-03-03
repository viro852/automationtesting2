package ru.ibs.framework.dnsframework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductSelectionPage extends BasePage {

    @FindBy(xpath = "//h1")
    WebElement h1;

    @FindBy(xpath = "//div[@data-id=\"product\"]")
    List<WebElement> productSelectionPageList;

    public ProductSelectionPage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }


    @Step("Проверяем открылась ли страница")
    public ProductSelectionPage checkOpenPage(String expectedH1) {
        assertEquals(expectedH1, h1.getText(), "Мы не перешли на страницу c выбором товара");
        return this;
    }

    @Step("Выбираем товар по нужному id: '{productId}'")
    public ProductPage selectProductByProductId(String productID) {
        for (WebElement currentProduct : productSelectionPageList) {
            if (currentProduct.getAttribute("data-code").contains(productID)) {
                currentProduct.findElement(By.xpath("./a/span")).click();
                return new ProductPage();
            }
        }
        fail("Товар с артикулом: " + productID + " не найден на странице");
        return pageManager.getProductPage();
    }
}
