package ru.disanger.learning.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.disanger.learning.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoHomePage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ContactData contactData) {
        fillField(By.name("firstname"), contactData.getContactName());
        fillField(By.name("lastname"), contactData.getContactSurname());
        fillField(By.name("home"), contactData.getContactPhoneHome());
        fillField(By.name("email"), contactData.getContactEmail());
    }

    public void gotoAddContactPage() {
        click(By.linkText("add new"));
    }
}
