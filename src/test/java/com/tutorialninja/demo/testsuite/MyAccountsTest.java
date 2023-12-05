package com.tutorialninja.demo.testsuite;

import com.tutorialninja.demo.pages.MyAccountsPage;
import com.tutorialninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountsTest extends BaseTest {

    MyAccountsPage myAccounts = new MyAccountsPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

        //1.1 click on my account link
        //1.2 call the method “selectMyAccountOptions” method and pass the parameter “Register”

        String option = "Register";
        myAccounts.selectMyAccountOptions(option);

        //1.3 verify the text "Register Account"
        String expectedText1 = "Register Account";
        String actualText1 = myAccounts.getRegisterAccountText();
        Assert.assertEquals(expectedText1, actualText1);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        //2.1 Click on My Account Link. 2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        String option = "Login";
        myAccounts.selectMyAccountOptions(option);

        // 2.3 Verify the text “Returning Customer”.
        String expectedMessage = "Returning Customer";
        String actualMessage = myAccounts.getReturningCustomerText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {

        //3.1 click on my account link
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”

        String option = "Register";
        myAccounts.selectMyAccountOptions(option);

        //3.3 Enter First Name
        //3.4 Enter Last Name
        //3.5 Enter Email
        //3.6 Enter Telephone
        //3.7 Enter Password
        //3.8 Enter Password Confirm
        //3.9 Select Subscribe Yes radio button
        myAccounts.enterFirstName("Prime");
        myAccounts.enterLastName("Testing");
        myAccounts.enterEmail("Prime34568910@gmail.com");
        myAccounts.enterPhoneNumber("123456789");
        myAccounts.enterPassword("Prime@123");
        myAccounts.enterConfirmPassword("Prime@123");
        myAccounts.selectSubscribeButton("Yes");

        //3.10 click on privacy policy check box
        myAccounts.clickOnAgree();

        //3.11 click on continue button
        myAccounts.clickOnContinue();

        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedText2 = "Your Account Has Been Created!";
        String actualText2 = myAccounts.getAccountCreatedText();
        Assert.assertEquals(actualText2, expectedText2);

        //3.13 click on continue button
        myAccounts.clickOnContinue2();

        //3.14 Click on My Account Link.3.15 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        option = "Logout";
        myAccounts.selectMyAccountOptions(option);

        //3.16 verify the text "Account Logout"
        String expectedText3 = "Account Logout";
        String actualText3 = myAccounts.getAccountLogoutText();
        Assert.assertEquals(expectedText3, actualText3);
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 click on my account link 4.2 call the method "SelectMyAccountOptions" method and pass the parameter "Login"
        String option = "Login";
        myAccounts.selectMyAccountOptions(option);

        //4.3 Enter Email address
        myAccounts.enterEmailId("Prime1234568@gmail.com");

        // 4.5 Enter password
        myAccounts.enterPassword("Prime@123");

        //4.6 Click on Login button
        myAccounts.clickOnLogin();

        //4.7 Verify text “My Account”
        String expectedText = "My Account";
        String actualText = myAccounts.getMyAccountText();
        Assert.assertEquals(actualText, expectedText);

        //4.8 Click on My Account Link. 4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout
        option = "Logout";
        myAccounts.selectMyAccountOptions(option);

        // 4.10 Verify the text “Account Logout
        String expectedText1 = "Account Logout";
        String actualText1 = myAccounts.getAccountLogoutText();
        Assert.assertEquals(actualText1, expectedText1);

        //4.11 Click on Continue button
        myAccounts.clickOnContinue();
    }
}
