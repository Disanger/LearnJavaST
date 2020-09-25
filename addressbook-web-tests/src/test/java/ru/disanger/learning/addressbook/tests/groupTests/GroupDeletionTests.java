package ru.disanger.learning.addressbook.tests.groupTests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.disanger.learning.addressbook.model.GroupData;
import ru.disanger.learning.addressbook.tests.TestBase;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.goTo().groupPage();
    //Check preconditions and make required data
    if (!app.group().isThereAGroup()) {
      app.group().create(new GroupData("Test1", null, null));
    }
    List<GroupData> before = app.group().getList();
    int i = before.size() - 1;
    //Beginning of test
    app.group().delete(i);
    List<GroupData> after = app.group().getList();
    Assert.assertEquals(after.size(), i);

    before.remove(i);
    Assert.assertEquals(before, after);

  }

}
