package by.stqa.pft.addressbook.tests;


import by.stqa.pft.addressbook.model.ContactData;
import by.stqa.pft.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactToGroupTests extends TestBase {



    @Test
    public void testAddContactToGroupTests() {
        Contacts before = app.db().contacts();
        app.contact().addToGroup(before.iterator().next());
    }
}
