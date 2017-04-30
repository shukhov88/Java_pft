package by.stqa.pft.addressbook.tests;


import by.stqa.pft.addressbook.model.Contacts;
import by.stqa.pft.addressbook.model.NewContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().mainPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new NewContactData().withFirstName("t").withLastName("tr").
                    withAddress("tre").withMobilePhone("qwe").withEmail("qwert").withGroup("test1"), true);
        }
    }
    @Test
    public void testContactModification() {

        Contacts before = app.contact().all();
        NewContactData modifiedContact = before.iterator().next();
        NewContactData contact = new NewContactData().withId(modifiedContact.getId()).withFirstName("t").withLastName("modified")
                .withAddress("tre").withMobilePhone("qwe").withEmail("qwert");
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }


}
