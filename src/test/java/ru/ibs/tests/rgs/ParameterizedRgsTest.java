package ru.ibs.tests.rgs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.*;


public class ParameterizedRgsTest extends RgsTestsConfig {

    @ParameterizedTest
    @MethodSource("getDataForParametrizedTest")
    public void dummyTest(String firstName, String secondName, String middleName) {

        assertEquals("ПАО СК «Росгосстрах» — флагман отечественного рынка страхования", driver.getTitle(), "Мы не перешли на сайт,тайтлы разные");

        String cookieAlertButtonCssPath = "button[class='btn--text']";
        WebElement cookieAlert = driver.findElement(By.cssSelector(cookieAlertButtonCssPath));
        cookieAlert.click();

        String healthInsuranceButtonXpath = "//span[text()=\"Здоровье\"]";
        WebElement healthInsurance = driver.findElement(By.xpath(healthInsuranceButtonXpath));
        waitUntilElementToBeClickable(healthInsurance);
        healthInsurance.click();

        String tickProtectionButtonXpath = "//a[text()=\"Защита от клеща\"]";
        WebElement tickProtection = driver.findElement(By.xpath(tickProtectionButtonXpath));
        waitUntilElementToBeClickable(tickProtection);
        tickProtection.click();

        WebElement tickProtectionH1 = driver.findElement(By.xpath("//h1[text()=\"Защита от клеща\"]"));
        assertEquals("Защита от клеща", tickProtectionH1.getAttribute("innerText"), "Мы не перешли на страницу страховки от клеща");


        String buyOnlineButtonXpath = "//span[contains(text(),\"Куп\")]";
        WebElement buyOnlineButton = driver.findElement(By.xpath(buyOnlineButtonXpath));
        waitUntilElementToBeClickable(buyOnlineButton);
        buyOnlineButton.click();

        String pageTitleXpath = "//h2[text()=\"Купить полис онлайн\"]";
        waitUntilElementToBeVisible(By.xpath(pageTitleXpath));


        String resoluteInsuranceIframe = "RESOLUTE_INSURANCE";
        switchToIframe(resoluteInsuranceIframe);

        String beginDateButtonXpath = "//div[@data-name=\'content.contract.beginDate\']//button[@class=\'calendar-button btn btn-outline-primary\']";
        WebElement beginDateIcon = driver.findElement(By.xpath(beginDateButtonXpath));
        waitUntilElementToBeClickable(beginDateIcon);
        beginDateIcon.click();


        String requiredMonth = "Июнь";
        String shownMonthButtonXpath = "//button[@class=\"rounded-0 border-0 outline-0 btn btn-outline-link\"]/span[@class=\"text-capitalize\"]";
        String monthSwitcherButtonXpath = "//div[@class=\"d-flex justify-content-between bg-white border-bottom\"]//button[3]";
        while (!driver.findElement(By.xpath(shownMonthButtonXpath)).getText().contains(requiredMonth)) {

            WebElement monthSwitcher = driver.findElement(By.xpath(monthSwitcherButtonXpath));
            waitUntilElementToBeClickable(monthSwitcher);
            monthSwitcher.click();

        }
        String dayOfMonthButtonXpath = "//div[@class=\"w-100 btn-group-sm btn-group\"]//button[text()=19]";
        WebElement dayOfMonth = driver.findElement(By.xpath(dayOfMonthButtonXpath));
        dayOfMonth.click();

        String dateOfBirthFieldXpath = "//input[@name=\"content.insuredPerson.list[0].dob\"]";
        WebElement dateOfBirthField = driver.findElement(By.xpath(dateOfBirthFieldXpath));
        fillInputField(dateOfBirthField, "12.12.1992");


        String healingOnlyBuyButtonXpath = "//td[@class=\"pt-3 text-center\"][1]//button[@class=\"d-none d-md-inline-block btn btn-secondary\"][1]";
        WebElement healingOnlyBuyButton = driver.findElement(By.xpath(healingOnlyBuyButtonXpath));
        waitUntilElementToBeClickable(healingOnlyBuyButton);
        healingOnlyBuyButton.click();

        String secNameFieldXpath = "//input[@name=\"content.insuredPerson.list[0].lastName\"]";
        WebElement secNameField = driver.findElement(By.xpath(secNameFieldXpath));
        fillInputField(secNameField, secondName);

        String firstNameFieldXpath="//input[@name=\"content.insuredPerson.list[0].firstName\"]";
        WebElement firstNameField = driver.findElement(By.xpath(firstNameFieldXpath));
        fillInputField(firstNameField,firstName);

        String middleNameFieldXpath="//input[@name=\"content.insuredPerson.list[0].middleName\"]";
        WebElement middleNameField = driver.findElement(By.xpath(middleNameFieldXpath ));
        fillInputField(middleNameField,middleName);

        String sexButtonXpath="//button[contains(text(),\"Муж\")]";
        WebElement sexButton = driver.findElement(By.xpath(sexButtonXpath));
        waitUntilElementToBeClickable(sexButton);
        sexButton.click();

        String insuredPersonSwitcherXpath="//div[@class=\"custom-switch custom-control\"]//label[@for=\"insuredPerson-0-isInsured\"]";
        WebElement insuredPersonSwitcher = driver.findElement(By.xpath(insuredPersonSwitcherXpath));
        waitUntilElementToBeClickable(insuredPersonSwitcher);
        insuredPersonSwitcher.click();

        String continueButtonXpath = "//button[@class=\"btn btn-secondary\"]";
        WebElement continueButton = driver.findElement(By.xpath(continueButtonXpath));
        waitUntilElementToBeClickable(continueButton);
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
        assertEquals("SberPay", driver.findElement(By.xpath("//div[@data-test-id=\"box-title\" and contains(text(),\"Sber\")]")).getText(), "Не удалось перейти на страницу оплаты страховки");
    }


    public WebElement waitUntilElementToBeClickable(WebElement elementForCheck) {
        return wait.until(ExpectedConditions.elementToBeClickable(elementForCheck));
    }

    public WebElement waitUntilElementToBeVisible(By byPath) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(byPath));
    }

    public void switchToIframe(String iFrame) {
        driver.switchTo().frame(iFrame);
    }

    public void fillInputField(WebElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
        boolean checkFlag = wait.until(ExpectedConditions.attributeContains(element, "value", value));
        assertTrue(checkFlag, "Поле заполнено некоректно");
    }

    public static Stream<Arguments> getDataForParametrizedTest() {
        return Stream.of(
                arguments("Александр", "Роздин", "Андреевич"),
                arguments("Виталий", "Батьков", "Ракович"),
                arguments("Константин", "Чудов", "Надеждович")

        );
    }

}
