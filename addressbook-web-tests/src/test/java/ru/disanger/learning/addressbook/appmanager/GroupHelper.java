package ru.disanger.learning.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.disanger.learning.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends BaseHelper{

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitCreation() {
        click(By.name("submit"));
    }

    public void fillForm(GroupData groupData) {
        fillField(By.name("group_name"), groupData.getGroupName());
        fillField(By.name("group_header"), groupData.getGroupHeader());
        fillField(By.name("group_footer"), groupData.getGroupFooter());
    }

    public void initCreation() {
        click(By.name("new"));
    }

    public void deleteSelected() {
        click(By.name("delete"));
    }

    public void selectByID(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initModification() {
        click(By.name("edit"));
    }

    public void submitModification() {
        click(By.name("update"));
    }

    public void create(GroupData group) {
        initCreation();
        fillForm(group);
        submitCreation();
        returnToGroupPage();
    }

    public void modify(GroupData group) {
        selectByID(group.getGroupID());
        initModification();
        fillForm(group);
        submitModification();
        returnToGroupPage();
    }

    public void delete(GroupData group) {
        selectByID(group.getGroupID());
        deleteSelected();
        returnToGroupPage();
    }

    public Set<GroupData> all() {
        Set<GroupData> groups = new HashSet<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withID(id).withName(name));
        }

        return groups;
    }
}
