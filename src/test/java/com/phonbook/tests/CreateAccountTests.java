package com.phonbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    // precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.isLoginLinkPresent()){
            app.clickOnSignOutButton();
        }
        // click Login link
        app.clickOnLoginLink();
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        // enter email field
        // enter password field
        app.fillLoginRegistrationForm(new User().setEmail("brn@gmail.com").setPassword( "Kan123$-_$"));

        // click on Registration
        app.clickOnRegistrationButton();

        // assert user logged in(check Sign Out button displayed)
        Assert.assertTrue(app.isAlertPresent());

    }

}
