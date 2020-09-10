package ru.disanger.learning.addressbook.tests.contactTests;

import org.testng.annotations.Test;
import ru.disanger.learning.addressbook.model.ContactData;
import ru.disanger.learning.addressbook.tests.TestBase;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification(){
        //Check preconditions and make required data
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("TestName",
                    "TestSurname",
                    "880005553535",
                    "test@mail.zrt",
                    "TestNew1"));
            app.getNavigationHelper().gotoHomePage();
        }
        //Beginning of test
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("NewName",
                "NewSurname",
                "89876543210",
                "TEST@yandex.zrt",
                null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
