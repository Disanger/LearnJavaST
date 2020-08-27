package ru.disanger.learning.addressbook.tests.contactTests;

import org.testng.annotations.Test;
import ru.disanger.learning.addressbook.model.ContactData;
import ru.disanger.learning.addressbook.tests.TestBase;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification(){
        app.getContactHelper().initGroupModification();
        app.getContactHelper().fillContactForm(new ContactData("NewName",
                "NewSurname",
                "89876543210",
                "TEST@yandex.zrt"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
