package ru.disanger.learning.addressbook.tests.groupTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.disanger.learning.addressbook.model.GroupData;
import ru.disanger.learning.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        //Check preconditions and make required data
        if (!app.group().isThereAGroup()) {
            app.group().create(new GroupData().withName("Test1"));
        }
    }

    @Test
    public void testGroupModification() {
        int index = 0;
        List<GroupData> before = app.group().getList();
        GroupData group = new GroupData().withID(before.get(index).getGroupID())
                .withName("TestNew1")
                .withHeader("TestNew2")
                .withFooter("TestNew3");
        //Beginning of test
        app.group().modify(index, group);

        List<GroupData> after = app.group().getList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byGroupID = (g1, g2) -> Integer.compare(g1.getGroupID(), g2.getGroupID());
        before.sort(byGroupID);
        after.sort(byGroupID);
        Assert.assertEquals(before, after);
    }
}
