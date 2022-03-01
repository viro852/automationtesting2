package ru.ibs.tests.rgs;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RgsTest extends RgsTestsConfig {



    @Test
    public void dummyTest() {
        //startPage.closeCookies();

        WebElement health = driver.findElement(By.xpath("//span[text()=\"Здоровье\"]"));
        health.click();

        WebElement tickProtection = driver.findElement(By.xpath("//a[text()=\"Защита от клеща\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(tickProtection));
        tickProtection.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()=\"Защита от клеща\"]")));
        WebElement tickProtectionH1 = driver.findElement(By.xpath("//h1[text()=\"Защита от клеща\"]"));
        assertEquals( "Защита от клеща", tickProtectionH1.getAttribute("innerText"),"Мы не перешли на страницу страховки от клеща");


        WebElement buyButton = driver.findElement(By.xpath("//span[contains(text(),\"Куп\")]"));
        buyButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()=\"Купить полис онлайн\"]")));
        driver.switchTo().frame("RESOLUTE_INSURANCE");
        WebElement beginDateIcon = driver.findElement(By.xpath("//div[@data-name=\'content.contract.beginDate\']//button[@class=\'calendar-button btn btn-outline-primary\']"));
        beginDateIcon.click();


        while (!driver.findElement(By.xpath("//button[@class=\"rounded-0 border-0 outline-0 btn btn-outline-link\"]/span[@class=\"text-capitalize\"]")).getText().contains("Июнь")) {
            WebElement monthSwitcher = driver.findElement(By.xpath("//div[@class=\"d-flex justify-content-between bg-white border-bottom\"]//button[3]"));
            monthSwitcher.click();

        }
        WebElement dayOfMonth = driver.findElement(By.xpath("//div[@class=\"w-100 btn-group-sm btn-group\"]//button[text()=19]"));
        dayOfMonth.click();

        WebElement dateOfBirthField = driver.findElement(By.xpath("//input[@name=\"content.insuredPerson.list[0].dob\"]"));
        dateOfBirthField.sendKeys("12.12.1992");

        WebElement healingOnlyBuyButton = driver.findElement(By.xpath("//td[@class=\"pt-3 text-center\"][1]//button[@class=\"d-none d-md-inline-block btn btn-secondary\"][1]"));
        healingOnlyBuyButton.click();

        WebElement secNameField = driver.findElement(By.xpath("//input[@name=\"content.insuredPerson.list[0].lastName\"]"));
        secNameField.sendKeys("Роздин");

        WebElement firstNameField = driver.findElement(By.xpath("//input[@name=\"content.insuredPerson.list[0].firstName\"]"));
        firstNameField.sendKeys("Виталий");

        WebElement middleNameField = driver.findElement(By.xpath("//input[@name=\"content.insuredPerson.list[0].middleName\"]"));
        middleNameField.sendKeys("Андреевич");

        WebElement sexButton = driver.findElement(By.xpath("//button[contains(text(),\"Муж\")]"));
        sexButton.click();

        WebElement insuredPersonSwitcher = driver.findElement(By.xpath("//div[@class=\"custom-switch custom-control\"]//label[@for=\"insuredPerson-0-isInsured\"]"));
        insuredPersonSwitcher.click();

        WebElement continueButton = driver.findElement(By.xpath("//button[@class=\"btn btn-secondary\"]"));
        continueButton.click();

        WebElement phoneField = driver.findElement(By.xpath("//input[@name=\"content.policyHolder.phone\"]"));
        phoneField.sendKeys("9137659067");

        WebElement emailField = driver.findElement(By.xpath("//input[@name=\"content.policyHolder.email\"]"));
        emailField.sendKeys("egoza87@list.com");

        WebElement emailField2 = driver.findElement(By.xpath("//input[@name=\"content.policyHolder.email2\"]"));
        emailField2.sendKeys("egoza87@list.com");


        WebElement passportSeriaField = driver.findElement(By.xpath("//input[@name=\"content.policyHolder.document.seria\"]"));
        passportSeriaField.sendKeys("5984");

        WebElement passportNumberField = driver.findElement(By.xpath("//input[@name=\"content.policyHolder.document.number\"]"));
        passportNumberField.sendKeys("196745");

        WebElement continueButton2 = driver.findElement(By.xpath("//button[@class=\"btn btn-secondary\"]"));
        continueButton2.click();

        WebElement acceptAllRadioButton = driver.findElement(By.xpath("//div[@class=\"custom-checkbox custom-control\"]//label[@for=\"content.temp.acceptAll_custom_input\"]"));
        acceptAllRadioButton.click();

        WebElement payButton = driver.findElement(By.xpath("//button[text()=\"Оплатить\"]"));
        payButton.click();

        driver.switchTo().defaultContent();

        WebElement checkForElement = driver.findElement(By.xpath("//div[@data-test-id=\"box-title\" and contains(text(),\"Sber\")]"));
        wait.until(ExpectedConditions.visibilityOf(checkForElement));
        assertEquals( "SberPay", driver.findElement(By.xpath("//div[@data-test-id=\"box-title\" and contains(text(),\"Sber\")]")).getText(),"Не удалось перейти на страницу оплаты страховки");
    }


    @Test
    @Disabled("пока не надо ")
    public void dummy2() {

    }
}
