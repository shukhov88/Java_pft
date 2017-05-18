package by.stqa.pft.addressbook.tests;


import by.stqa.pft.addressbook.model.ContactData;
import by.stqa.pft.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    /*@BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().mainPage();
            app.contact().create(new ContactData().withFirstName("t").withLastName("tr").
                    withAddress("tre").withMobilePhone("qwe").withEmail("qwert").withGroup("test1"), true);
        }
    }*/
    @Test
    public void testContactModification() {

        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("t").withLastName("modified")
                .withAddress("tre").withMobilePhone("qwe").withEmail("qwert");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }


}
