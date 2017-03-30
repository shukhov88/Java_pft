package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.NewContactData;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactModification() {

        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new NewContactData("t", "tr", "tre", "qwe", "qwert", "test1"), true);
        }
        app.getNavigationHelper().goToMainPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().acceptAlert();
    }
}
