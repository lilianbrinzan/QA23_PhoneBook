package com.phonebook.tests;

import com.phonebook.fw.DataProviders;
import com.phonebook.model.Contact;
import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContactTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()){
            app.getHeader().clickOnSignOutButton();
        }
        app.getHeader().clickOnLoginLink();
        app.getUser().fillLoginRegistrationForm(new User().setEmail("brn@gmail.com").setPassword( "Kan123$-_$"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest(){
        //click on the ADD link
        app.getHeader().clickOnAddLink();
        // int i = (int) (System.currentTimeMillis() / 1000)%3600;
        //fill in the add contact form
        app.getContact().fillAddContactForm(new Contact()
                .setName("Karl")
                .setLastname("Adam")
                .setPhone("1234567890")
                .setEmail("brn@gmail.com")
                .setAddress("Koblenz")
                .setDesc("goalkeeper"));
        //click on the Save button
        app.getContact().clickOnSaveButton();
        //assert the contact is added
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));

    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "addContactFromCsvFile")
    public void addContactFromCsvFilePositiveTest(Contact contact) {

        app.getHeader().clickOnAddLink();
        app.getContact().fillAddContactForm(contact);

        app.getContact().clickOnSaveButton();

    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }
    // VOM
    // POM
}