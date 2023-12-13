package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(xpath = "//img[@alt='client brand banner']")
    WebElement orangeHRMLogo;

//    @CacheLookup
//    @FindBy(xpath = "//li[1]//a[1]//span[1]")
//    WebElement adminLink;

    @CacheLookup
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > aside:nth-child(1) > nav:nth-child(1) > div:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1) > span:nth-child(2)")
    WebElement adminTab;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='PIM']")
    WebElement PIMLink;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Leave']")
    WebElement leaveLink;

    public String getWelcomeText() {
        return getTextFromElement(welcomeText);
    }

    public boolean verifyOrangeHRMLogo() {
        return driver.findElement((By) orangeHRMLogo).isDisplayed();
    }

//    public void clickOnAdminLink() {
//        clickOnElement(adminLink);
//    }

    public void clickOnAdminTab(){
        clickOnElement(adminTab);
    }

    public void clickOnPIMLink() {
        clickOnElement(PIMLink);
    }

    public void clickOnLeaveLink() {
        clickOnElement(leaveLink);
    }

}
