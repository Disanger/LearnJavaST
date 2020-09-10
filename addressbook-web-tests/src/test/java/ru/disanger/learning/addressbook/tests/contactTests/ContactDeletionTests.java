package ru.disanger.learning.addressbook.tests.contactTests;

import org.testng.annotations.Test;
import ru.disanger.learning.addressbook.model.ContactData;
import ru.disanger.learning.addressbook.tests.TestBase;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion() {
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
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getNavigationHelper().waitReturnAfterDeletingContacts();
    }
}
