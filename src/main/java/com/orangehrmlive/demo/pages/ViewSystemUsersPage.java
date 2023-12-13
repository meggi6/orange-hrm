package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ViewSystemUsersPage extends Utility {

    @CacheLookup
    @FindBy(className = "oxd-table-filter-title")
    WebElement systemUsersText;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement AddButton;

    @CacheLookup
    @FindBy(css = "div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']")
    WebElement username;

    @CacheLookup
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > i:nth-child(1)")
    WebElement  userRole;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameFieldInSystemUsers;

    @CacheLookup
    @FindBy(css = "div:nth-child(4) div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(2) i:nth-child(1)")
    WebElement  Status;

    @CacheLookup
    @FindBy(className = "orangehrm-left-space")
    WebElement  searchButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-body']//div//div[@class='oxd-table-cell oxd-padding-cell'][2]//div")
    WebElement  resultList;

    //Delete User
    @CacheLookup
    @FindBy(css = "div[class='oxd-table-card-cell-checkbox'] i[class='oxd-icon bi-check oxd-checkbox-input-icon']")
    WebElement  checkBox;

    @CacheLookup
    @FindBy(className = "bi-trash")
    WebElement  deleteButton ;

    @CacheLookup
    @FindBy(className = "orangehrm-dialog-popup")
    WebElement popUp;

    @CacheLookup
    @FindBy(css = ".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text")
    WebElement deletedText;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='(1) Record Found']")
    WebElement oneRecordFoundMessage;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement resetButtonInSystemUsers;

    public String getSystemUsersText(){
        String text = getTextFromElement(systemUsersText);
        return text;
    }

    public void clickOnAddButton(){
        clickOnElement(AddButton);
    }

    //Search The User Created and Verify

    public void enterUserName(String user_name){
        sendTextToElement(username, user_name);
    }

    public void selectUserRoleForSearchUser(String text){
        clickOnElement(userRole);
        List<WebElement> userRoleList = driver.findElements
                (By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > i:nth-child(1)"));
        for (WebElement element:userRoleList) {
            if (element.getText().contains(text)){
                element.click();
                break;
            }
        }
    }

    public void sendDataToEmployeeNameFieldInSystemUsers(String eName) {
        sendTextToElement(employeeNameFieldInSystemUsers, eName);
    }

    public void selectStatusForSearchUser(String text){
        clickOnElement(Status);
        List<WebElement> statusList = driver.findElements
                (By.cssSelector("div:nth-child(4) div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(2) i:nth-child(1)"));
        for (WebElement element:statusList) {
            if (element.getText().contains(text)){
                element.click();
                break;
            }
        }
    }

    public void clickOnSearchButton(){
        clickOnElement(searchButton);
    }

    public boolean verifyUserFromSearchList(String user){
        List<WebElement> searchList = driver.findElements(By.xpath("//div[@class='oxd-table-body']//div//div[@class='oxd-table-cell oxd-padding-cell'][2]//div"));
        return searchList.contains(user);
//        for (WebElement element:searchList) {
//            if (element.getText().contains(user)){
//                break;
//            }
//        return getUserFromSearchList(user);
        //String text = getTextFromElement(resultList);
        //return text;
    }

    //Delete User
    public void clickOnCheckboxButton(){
        clickOnElement(checkBox);
    }

    public void clickOnCDeleteButton(){
        clickOnElement(deleteButton);
    }

    public void clickOnPopUp(){
        acceptAlert();
    }

    public String getDeletedTextMessage(){
        String text = getTextFromElement(deletedText);
        return text;
    }

    public String getOneRecordFoundMessage () {
        return getTextFromElement(oneRecordFoundMessage);
    }

    public String getRecordFromResultList () {
        return getTextFromElement(resultList);
    }

    public void clickOnResetButtonInSystemUsers() {
        clickOnElement(resetButtonInSystemUsers);
    }
}
