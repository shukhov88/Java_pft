package by.stqa.pft.addressbook.tests;


import by.stqa.pft.addressbook.model.NewContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().submitContactModification();
        app.getContactHelper().fillContactForm(new NewContactData("t", "tr", "tre", "qwe", "qwert", null), false);
        app.getContactHelper().submitConatactCreation();
    }
}
