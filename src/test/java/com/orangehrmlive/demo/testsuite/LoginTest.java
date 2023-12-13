package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        dashboardPage = new DashboardPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldLoginSuccessFully() {
        loginPage.loginWithValidCredentials("Admin", "admin123");
        String expectedMessage = "Dashboard";
        String actualMessage = dashboardPage.getWelcomeText().substring(0, expectedMessage.length());
        Assert.assertEquals(actualMessage, expectedMessage, "DashboardPage is not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatTheLogoDisplayOnHomePage(){
        loginPage.loginWithValidCredentials("Admin", "admin123");
        Assert.assertTrue(homePage.verifyOrangeHRMLogo());
    }

    @Test(groups = {"smoke", "regression"})
    public void VerifyUserShouldLogOutSuccessFully(){
        loginPage.loginWithValidCredentials("Admin", "admin123");
        dashboardPage.clickOnUserProfileLogo();
        dashboardPage.mouseHoverAndClickOnLogOut();
        String expectedLoginPanelText = "Login";
        String actualLoginPanelText = loginPage.verifyTheLoginPanelText();
        Assert.assertEquals(actualLoginPanelText, expectedLoginPanelText);
    }

    @Test(dataProvider = "credentials", dataProviderClass = TestData.class, groups = {"regression"})
    public void verifyErrorMessageWithInvalidCredentials(String username, String password, String errorMessage) {
        SoftAssert softAssert = new SoftAssert();
        loginPage.loginWithValidCredentials(username, password);
        String expectedErrorMessage = errorMessage;
        String actualErrorMessage = loginPage.getPasswordFieldBlankErrorMessage();
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
        softAssert.assertAll();
    }
}
