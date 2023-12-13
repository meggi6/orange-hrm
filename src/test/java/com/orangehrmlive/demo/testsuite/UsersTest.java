package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;

public class UsersTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    AdminPage adminPage;
    ViewSystemUsersPage viewSystemUsersPage;
    AddUserPage addUserPage;
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        adminPage = new AdminPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        addUserPage = new AddUserPage();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "regression"})
    public void adminShouldAddUserSuccessFully() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        //Login to Application
        loginPage.loginWithValidCredentials("Admin", "admin123");
        //click On "Admin" Tab
        homePage.clickOnAdminTab();
        //Verify "System Users" Text
        softAssert.assertTrue(viewSystemUsersPage.getSystemUsersText().contains("System Users"));
        //click On "Add" button
        viewSystemUsersPage.clickOnAddButton();
        //Verify "Add User" Text
        softAssert.assertTrue(addUserPage.getAddUsersText().contains("Add User"));
        //Select User Role "Admin"
        addUserPage.selectUserRoleFromDropDown();
        //Enter Employee Name
        addUserPage.employeeName("Maggie Manning");
        //Select status "Disable"
        addUserPage.selectStatusFromDropDown("Disabled");
        //Enter Username
        addUserPage.userName("meggi123");
        //Enter password
        addUserPage.enterPasswords("ajay@123", "ajay@123");
        //click On "Save" Button
        addUserPage.clickOnSaveButton();
        //verify message "Successfully Saved"
        softAssert.assertTrue(addUserPage.getSuccessfullyAddUserText().contains("Successfully Saved"));
        softAssert.assertAll();
    }

    @Test (groups = {"smoke", "regression"})
    public void searchTheUserCreatedAndVerifyIt() {
        SoftAssert softAssert = new SoftAssert();
        //Login to Application
        loginPage.loginWithValidCredentials("Admin", "admin123");
        //click On "Admin" Tab
        homePage.clickOnAdminTab();
        //Verify "System Users" Text
        softAssert.assertTrue(viewSystemUsersPage.getSystemUsersText().contains("System Users"));
        //Enter Username
        viewSystemUsersPage.enterUserName("meggi123");
       //Select User Role
        viewSystemUsersPage.selectUserRoleForSearchUser("Admin");
        //Select Status
        viewSystemUsersPage.selectStatusForSearchUser("Disabled");
        //Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();
        //Verify the User should be in Result list.
        softAssert.assertTrue(viewSystemUsersPage.verifyUserFromSearchList("meggi123"));
        softAssert.assertAll();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {
        SoftAssert softAssert = new SoftAssert();
        //Login to Application
        loginPage.loginWithValidCredentials("Admin", "admin123");
        //click On "Admin" Tab
        homePage.clickOnAdminTab();
        //Verify "System Users" Text
        softAssert.assertTrue(viewSystemUsersPage.getSystemUsersText().contains("System Users"));
        //Enter Username
        viewSystemUsersPage.enterUserName("meggi123");
        //Select User Role
        viewSystemUsersPage.selectUserRoleForSearchUser("Admin");
        //Select Status
        viewSystemUsersPage.selectStatusForSearchUser("Disabled");
        //Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();
        //Verify the User should be in Result list.
        softAssert.assertTrue(viewSystemUsersPage.verifyUserFromSearchList("meggi123"));
        //Click on Check box
        viewSystemUsersPage.clickOnCheckboxButton();
        // Click on Delete Button
        viewSystemUsersPage.clickOnCDeleteButton();
        // Popup will display
        viewSystemUsersPage.clickOnPopUp();
        // Click on Ok Button on Popup
        // verify message "Successfully Deleted"
        softAssert.assertTrue(viewSystemUsersPage.getDeletedTextMessage().contains("Successfully Deleted"));
        softAssert.assertAll();
    }

    @Test(dataProvider = "user details", dataProviderClass = TestData.class, groups = {"regression"})
    public void searchTheUserAndVerifyTheMessageRecordFound(String username, String userRole, String eName, String status) {
        SoftAssert softAssert = new SoftAssert();
        loginPage.loginWithValidCredentials("Admin", "admin123");
        homePage.clickOnAdminTab();
        softAssert.assertTrue(viewSystemUsersPage.getSystemUsersText().contains("System Users"));
        viewSystemUsersPage.enterUserName(username);
        viewSystemUsersPage.selectUserRoleForSearchUser(userRole);
        viewSystemUsersPage.sendDataToEmployeeNameFieldInSystemUsers(eName);
        viewSystemUsersPage.selectStatusForSearchUser(status);
        viewSystemUsersPage.clickOnSearchButton();
        softAssert.assertTrue(viewSystemUsersPage.getOneRecordFoundMessage().contains(username));
        viewSystemUsersPage.clickOnResetButtonInSystemUsers();
        softAssert.assertAll();
    }
}
