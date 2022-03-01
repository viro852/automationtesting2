package ru.ibs.framework.dnsframework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"product-card-top__code\"]")
    WebElement productId;

    @FindBy(xpath = "//div[@class=\"product-buy product-buy_one-line\"]//button[text()='Купить']")
    WebElement passiveBuyButton;

    @FindBy(xpath = "//a[@class=\"cart-modal__button button-ui button-ui_brand\"]")
    WebElement emergingAddToCartButton;


    public ProductPage checkOpenPage(String productId) {
        assertEquals(productId, this.productId.getText(), "Мы не перешли на страницу нужного товара");
        return this;
    }

    public ProductPage clickBuyButton() {
        moveToElement(passiveBuyButton);
        passiveBuyButton.click();
        return this;
    }

    public void clickEmergingAddToCartButton() {
        waitUntilElementToBeClickable(emergingAddToCartButton).click();
    }
}
