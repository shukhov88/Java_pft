package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.NewContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {

        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new NewContactData("t", "tr", "tre", "qwe", "qwert", "test1"), true);
        }
        List<NewContactData> before = app.getContactHelper().getContactsList();
        app.getNavigationHelper().goToMainPage();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().acceptAlert();
        List<NewContactData> after = app.getContactHelper().getContactsList();

        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
