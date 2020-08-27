package ru.disanger.learning.addressbook.tests.contactTests;

import org.testng.annotations.Test;
import ru.disanger.learning.addressbook.tests.TestBase;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion() {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getNavigationHelper().waitReturnAfterDeletingContacts();
    }
}
