package ru.disanger.learning.addressbook.tests.contactTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.disanger.learning.addressbook.model.ContactData;
import ru.disanger.learning.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

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
        List<ContactData> before = app.getContactHelper().getContactList();
        //Beginning of test
        app.getContactHelper().initContactModification(0);
        ContactData contact = new ContactData(before.get(0).getContactID(),
                "NewName",
                "NewSurname",
                "89876543210",
                "TEST@yandex.zrt",
                null);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(0);
        before.add(contact);
        Comparator<? super ContactData> byContactID = (c1, c2) -> Integer.compare(c1.getContactID(), c2.getContactID());
        before.sort(byContactID);
        after.sort(byContactID);
        Assert.assertEquals(before, after);
    }
}
