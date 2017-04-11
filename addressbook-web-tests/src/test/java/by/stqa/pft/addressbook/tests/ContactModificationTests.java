package by.stqa.pft.addressbook.tests;


import by.stqa.pft.addressbook.model.NewContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToMainPage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new NewContactData("t", "tr", "tre", "qwe", "qwert", "test1"), true);
        }
        List<NewContactData> before = app.getContactHelper().getContactsList();
        app.getContactHelper().initContactModification(before.size() - 1);
        NewContactData cont = new NewContactData("t", "modified", "tre", "qwe", "qwert", null);
        app.getContactHelper().fillContactForm(cont, false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToMainPage();
        List<NewContactData> after = app.getContactHelper().getContactsList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(cont);
        Comparator<? super NewContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
