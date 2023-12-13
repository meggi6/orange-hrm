package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends Utility {

    @CacheLookup
    @FindBy(className = "orangehrm-main-title")
    WebElement addUserText;

    @CacheLookup
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > i:nth-child(1)")
    WebElement  adduserRole;

    @CacheLookup
    @FindBy(css = "input[placeholder='Type for hints...']")
    WebElement  employeeName;
    //.oxd-autocomplete-text-input.oxd-autocomplete-text-input--active.oxd-autocomplete-text-input--error

    @CacheLookup
    @FindBy(xpath = "div[role='listbox']")
    WebElement  employeeReferenceNames;

    @CacheLookup
    @FindBy(css = "div[class='oxd-form-row'] div[class='oxd-grid-2 orangehrm-full-width-grid'] div[class='oxd-grid-item oxd-grid-item--gutters'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']")
    WebElement  addUsernameField;


    @CacheLookup
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > i:nth-child(1)")
    WebElement  addStatus;

    @CacheLookup
    @FindBy(css = "div[class='oxd-grid-item oxd-grid-item--gutters user-password-cell'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[type='password']")
    WebElement  passwordField;

    @CacheLookup
    @FindBy(css = "div[class='oxd-grid-item oxd-grid-item--gutters'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[type='password']")
    WebElement  confirmPasswordField;

    @CacheLookup
    @FindBy(className = "orangehrm-left-space")
    WebElement  saveButton;

    @CacheLookup
    @FindBy(css = ".oxd-toast.oxd-toast--success.oxd-toast-container--toast")
    WebElement  successfullySavedText;


    //Admin Should Add User SuccessFully

    public String getAddUsersText(){
        String text = getTextFromElement(addUserText);
        return text;
    }

    public void selectUserRoleFromDropDown() throws InterruptedException {
        WebElement userRoleList = driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > i:nth-child(1)"));
        userRoleList.click();
        userRoleList.sendKeys(Keys.ARROW_DOWN);
        userRoleList.sendKeys(Keys.ENTER);
    }

    public void employeeName(String name){
        sendTextToElement(employeeName, name);
    }

    public void selectStatusFromDropDown(String text) throws InterruptedException {
        WebElement statusList = driver.findElement
                (By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > i:nth-child(1)"));
        statusList.click();
        statusList.sendKeys(Keys.ARROW_DOWN);
        statusList.sendKeys(Keys.ENTER);
    }

    public void userName(String username){
        sendTextToElement(addUsernameField, username);
    }

    public void enterPasswords(String password, String confirmPass) {
        sendTextToElement(passwordField, password);
        sendTextToElement(confirmPasswordField, confirmPass);
    }

    public void clickOnSaveButton(){
        clickOnElement(saveButton);
    }

    public String getSuccessfullyAddUserText(){
        String text = getTextFromElement(successfullySavedText);
        return text;
    }
}
