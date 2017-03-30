package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.NewContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().createContact(new NewContactData("t", "tr", "tre", "qwe", "qwert", "test1"), true);
    }
}
