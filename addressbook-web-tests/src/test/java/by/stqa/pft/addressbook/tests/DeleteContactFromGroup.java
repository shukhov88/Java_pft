package by.stqa.pft.addressbook.tests;


import by.stqa.pft.addressbook.model.ContactInGroupData;
import by.stqa.pft.addressbook.model.Contacts;
import by.stqa.pft.addressbook.model.Groups;
import by.stqa.pft.addressbook.model.ListOfContactsInGroup;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactFromGroup extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groupsWithContact().size() == 0) {
            Contacts before = app.db().contacts();
            app.contact().addToGroup(before.iterator().next());
            app.goTo().mainPage();
        }
    }

    @Test
    public void testDeleteContactFromGroup() {
        Groups list = app.db().groups();
        ListOfContactsInGroup before = app.db().groupsWithContact();
        ContactInGroupData toDelete = before.iterator().next();
        app.contact().removeFromGroup(list, toDelete);
        ListOfContactsInGroup after = app.db().groupsWithContact();

        assertThat(after, equalTo(before));
        System.out.println("after: " + after);
        System.out.println("before: " + before);
    }
}
