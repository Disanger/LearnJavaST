package ru.disanger.learning.addressbook.tests.groupTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.disanger.learning.addressbook.model.GroupData;
import ru.disanger.learning.addressbook.tests.TestBase;

import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        //Check preconditions and make required data
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("Test1", null, null));
        }
        //Beginning of test
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("TestNew1", "TestNew2", "TestNew3"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }
}
