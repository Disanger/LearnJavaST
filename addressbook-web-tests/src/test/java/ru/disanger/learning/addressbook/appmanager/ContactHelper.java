package ru.disanger.learning.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.disanger.learning.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void submitCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillForm(ContactData contactData, boolean creation) {
        fillField(By.name("firstname"), contactData.getContactName());
        fillField(By.name("lastname"), contactData.getContactSurname());
        fillField(By.name("home"), contactData.getContactPhoneHome());
        fillField(By.name("email"), contactData.getContactEmail());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void gotoAddContactPage() {
        click(By.linkText("add new"));
    }

    public void select(int number) {
        wd.findElements(By.name("selected[]")).get(number).click();
    }

    public void deleteSelected() {
        click(By.xpath("//input[@value='Delete']"));
        acceptAlert();
    }

    public void initModification(int number) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(number).click();
    }

    public void submitModification() {
        click(By.name("update"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void create(ContactData contactData) {
        gotoAddContactPage();
        fillForm(contactData, true);
        submitCreation();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//img[@alt='Edit']"));
    }

    public List<ContactData> getContactList() {
        List<ContactData>  contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String name = element.findElements(By.tagName("td")).get(2).getText();
            String surname = element.findElements(By.tagName("td")).get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id, name, surname, null, null, null);
            contacts.add(contact);
        }

        return contacts;
    }
}
