package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(name = "username")
    WebElement usernameField;

    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordField;


    @CacheLookup
    @FindBy(className = "orangehrm-login-button")
    WebElement loginButton ;

    @CacheLookup
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    WebElement passwordFieldBlankErrorMessage;

    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='Login']")
    WebElement loginPanelText;

    public void loginWithValidCredentials(String email,String password ){
        sendTextToElement(usernameField, email);
        sendTextToElement(passwordField, password);
        clickOnElement(loginButton);
    }

    public String verifyTheLoginPanelText() {
        return getTextFromElement(loginPanelText);
    }

    public String getPasswordFieldBlankErrorMessage() {
        return getTextFromElement(passwordFieldBlankErrorMessage);
    }

}
