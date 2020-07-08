package com.trycloud.pages;

import static com.trycloud.utilities.BrowserUtils.*;

import com.trycloud.utilities.Driver;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    @FindBy(xpath = "//img[@class='svg']")
    public WebElement notifications;


    @FindBy(xpath = "//div[@class='icon-contacts menutoggle']")
    public WebElement iconContacts;

    @FindBy(xpath = "//div[@class='avatardiv avatardiv-shown']//img")
    public WebElement T_image;

    @FindBy(xpath = "//div[@class='logo logo-icon']")
    public WebElement logoIcon;

    @FindBy(xpath = "//div[@class='header-right']//li[3]//a[1]")
    public WebElement logOut;

    @FindBy(xpath = "//div[@class='header-right']//li[1]//a[1]")
    public WebElement settings;


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    public void logOut() {
        clickWithJS(T_image);
        waitFor(2);
        clickWithJS(logOut);
    }

    public void goToSettings() {
        clickWithJS(T_image);
        waitForClickablility(settings, 5).click();

    }

    public void navigateToModule(String module) {


        String moduleLocator =  "//*[@id='appmenu']/li[@data-id='"+module+"']";
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 10);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 7);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)), 7);
        }
    }

}
