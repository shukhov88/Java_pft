package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.Contacts;
import by.stqa.pft.addressbook.model.NewContactData;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        Contacts before = app.contact().all();
        NewContactData contact = new NewContactData().withFirstName("t").withLastName("tr")
                .withAddress("tre").withMobilePhone("qwe").withEmail("qwert").withGroup("test1");
        app.contact().create(contact, true);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
