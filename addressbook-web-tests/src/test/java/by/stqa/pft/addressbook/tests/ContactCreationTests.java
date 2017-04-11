package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.NewContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        List<NewContactData> before = app.getContactHelper().getContactsList();
        NewContactData cont = new NewContactData("t", "tr", "tre", "qwe", "qwert", "test1");
        app.getContactHelper().createContact(cont, true);
        List<NewContactData> after = app.getContactHelper().getContactsList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(cont);
        Comparator<? super NewContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
