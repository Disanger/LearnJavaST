package ru.disanger.learning.addressbook.tests.contactTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.disanger.learning.addressbook.model.ContactData;
import ru.disanger.learning.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.contact().isThereAContact()) {
            app.contact().create(new ContactData("TestName",
                    "TestSurname",
                    "880005553535",
                    "test@mail.zrt",
                    "TestNew1"));
            app.goTo().homePage();
        }
    }

    @Test
    public void testContactModification(){
        List<ContactData> before = app.contact().getList();
        int i = 0;
        //Beginning of test
        app.contact().initModification(i);
        ContactData contact = new ContactData(before.get(i).getContactID(),
                "NewName",
                "NewSurname",
                "89876543210",
                "TEST@yandex.zrt",
                null);
        app.contact().modify(contact);
        List<ContactData> after = app.contact().getList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(i);
        before.add(contact);
        Comparator<? super ContactData> byContactID = (c1, c2) -> Integer.compare(c1.getContactID(), c2.getContactID());
        before.sort(byContactID);
        after.sort(byContactID);
        Assert.assertEquals(before, after);
    }
}
