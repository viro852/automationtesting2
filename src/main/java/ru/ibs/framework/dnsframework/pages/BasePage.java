package ru.ibs.framework.dnsframework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.framework.dnsframework.managers.DriverManager;
import ru.ibs.framework.dnsframework.managers.PageManager;

public class BasePage {

    protected DriverManager driverManager = DriverManager.getDriverManager();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), 10);
    protected PageManager pageManager = PageManager.getPageManager();

    public BasePage(){
        PageFactory.initElements(driverManager.getDriver(),this);
    }


    public WebElement waitUntilElementToBeClickable(WebElement element){
       return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void moveToElement(WebElement element){
        waitUntilVisibilityOfElement(element);
        Actions actions=new Actions(driverManager.getDriver());
        actions.moveToElement(element).perform();

    }

    public WebElement waitUntilVisibilityOfElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

//    public Boolean waitUntilInvisibilityOfElement(WebElement element){
//        return );
//    }

    public boolean elementIsPresent(WebElement element){
        if(element.isDisplayed()){
            return true;
        }
        return false;

    }

}
