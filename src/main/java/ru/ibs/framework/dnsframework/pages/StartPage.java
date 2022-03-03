package ru.ibs.framework.dnsframework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class StartPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"ui-input-search ui-input-search_presearch ui-input-search_white\"]//span[@class=\"ui-input-search__icon ui-input-search__icon_search ui-input-search__icon_presearch\"]")
    WebElement searchButton;

    @FindBy(xpath = "//a[@class=\"btn btn-additional\"]")
    WebElement whatTownButton;

    @FindBy(xpath = "//input[@class=\"ui-input-search__input ui-input-search__input_presearch\" and not(contains(@id,'null'))]")
    WebElement searchField;

    @Step("Подтверждаем наш город")
    public StartPage whatTownButtonClick() {

        waitUntilElementToBeClickable(whatTownButton);
        whatTownButton.click();

        assertFalse(driverManager.getDriver().findElement(By.xpath("//div[@class=\"header-top\"]//div//div[contains(@class,'header')]")).getAttribute("class").contains("w-choose-city-widget_city-select-popover-open"),"Клика не было, город не подтвержден!");


        return this;
    }

    @Step("Проверяем открылась ли стартовая страница")
    public StartPage checkOpenPage() {
        assertEquals("DNS – интернет магазин цифровой и бытовой техники по доступным ценам.", driverManager.getDriver().getTitle(), "Мы не перешли на страницу на стартовую страницу");
        return this;
    }

    @Step("Набираем {nameOfProduct} в поисковой строке")
    public ProductSelectionPage typeNameOfProductInSearchField(String nameOfProduct) {
        searchField.click();
        searchField.clear();
        searchField.sendKeys(nameOfProduct);
        wait.until(ExpectedConditions.attributeContains(searchField, "value", nameOfProduct));
        searchButton.click();

        return pageManager.getProductSelectionPage();
    }
}
