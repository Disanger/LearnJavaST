package ru.disanger.learning.addressbook.tests.contactTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.disanger.learning.addressbook.model.ContactData;
import ru.disanger.learning.addressbook.tests.TestBase;

import java.util.List;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion() {
        //Check preconditions and make required data
        if (!app.contact().isThereAContact()) {
            app.contact().create(new ContactData("TestName",
                    "TestSurname",
                    "880005553535",
                    "test@mail.zrt",
                    "TestNew1"));
            app.goTo().homePage();
        }
        List<ContactData> before = app.contact().getContactList();
        int i = before.size() - 1;
        //Beginning of test
        app.contact().select(i);
        app.contact().deleteSelected();
        app.goTo().waitReturnAfterDeletingContacts();

        List<ContactData> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), i);
        before.remove(i);
        Assert.assertEquals(before, after);
    }
}
