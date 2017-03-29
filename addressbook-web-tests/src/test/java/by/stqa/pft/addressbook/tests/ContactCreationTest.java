package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.NewContactData;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().goToNewContactPage();
        app.getContactHelper().fillContactForm(new NewContactData("t", "tr", "tre", "qwe", "qwert", "test1"), true);
        app.getContactHelper().submitConatactCreation();
    }
}
