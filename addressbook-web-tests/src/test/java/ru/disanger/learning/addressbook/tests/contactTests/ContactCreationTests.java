package ru.disanger.learning.addressbook.tests.contactTests;

import org.testng.annotations.*;
import ru.disanger.learning.addressbook.model.ContactData;
import ru.disanger.learning.addressbook.tests.TestBase;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation(){
        app.getContactHelper().gotoAddContactPage();
        app.getContactHelper().fillContactForm(new ContactData("TestName",
                "TestSurname",
                "880005553535",
                "test@mail.zrt",
                "test1"), true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().gotoHomePage();
    }

}
