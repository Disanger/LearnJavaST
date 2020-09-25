package ru.disanger.learning.addressbook.tests.groupTests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.disanger.learning.addressbook.model.GroupData;
import ru.disanger.learning.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    List<GroupData> before = app.group().getList();
    GroupData group = new GroupData().withName("Test1").withID(before.get(0).getGroupID());
    app.group().create(group);
    List<GroupData> after = app.group().getList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(group);
    Comparator<? super GroupData> byGroupID = (g1, g2) -> Integer.compare(g1.getGroupID(), g2.getGroupID());
    before.sort(byGroupID);
    after.sort(byGroupID);
    Assert.assertEquals(before, after);
  }

}
