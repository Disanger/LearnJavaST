package ru.disanger.learning.addressbook.tests.groupTests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.disanger.learning.addressbook.model.GroupData;
import ru.disanger.learning.addressbook.tests.TestBase;

import java.util.Set;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("Test1"));
    }
  }

  @Test
  public void testGroupDeletion() {
    Set<GroupData> before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedGroup);
    Assert.assertEquals(before, after);

  }

}
