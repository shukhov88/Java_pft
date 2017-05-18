package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.Contacts;
import by.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

    /*@BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().mainPage();
            app.contact().create(new ContactData().withFirstName("t").withLastName("tr").
                    withAddress("tre").withMobilePhone("qwe").withEmail("qwert").withGroup("test1"), true);
        }
    }*/

    @Test
    public void testContactDeletion() {
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(deletedContact)));
    }
}
