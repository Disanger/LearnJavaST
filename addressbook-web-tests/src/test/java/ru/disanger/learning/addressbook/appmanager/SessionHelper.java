package ru.disanger.learning.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends BaseHelper{

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String userpass) {
        fillField(By.name("user"), username);
        fillField(By.name("pass"), userpass);
        click(By.xpath("//input[@value='Login']"));
    }

    public void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }
}
