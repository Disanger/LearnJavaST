package ru.disanger.learning.addressbook.tests;

import org.testng.annotations.*;
import ru.disanger.learning.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation(){
        app.getContactHelper().gotoAddContactPage();
        app.getContactHelper().fillContactForm(new ContactData("TestName",
                "TestSurname",
                "880005553535",
                "test@mail.zrt"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().gotoHomePage();
    }

}
