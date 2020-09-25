package ru.disanger.learning.addressbook.tests.contactTests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.disanger.learning.addressbook.model.ContactData;
import ru.disanger.learning.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation(){
        List<ContactData> before = app.contact().getList();
        ContactData contact = new ContactData(before.get(0).getContactID(),
                "TestName",
                "TestSurname",
                "880005553535",
                "test@mail.zrt",
                "Test1");
        app.contact().create(contact);
        app.goTo().homePage();

        List<ContactData> after = app.contact().getList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byContactID = (c1, c2) -> Integer.compare(c1.getContactID(), c2.getContactID());
        before.sort(byContactID);
        after.sort(byContactID);
        Assert.assertEquals(before, after);
    }

}
