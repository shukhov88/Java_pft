package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.NewContactData;
import org.testng.annotations.Test;

public class NewContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().goToNewContactPage();
        app.getContactHelper().fillContactForm(new NewContactData("t", "tr", "tre", "qwe", "qwert", "1234567", "1234", "12345", "asgare"));
        app.getContactHelper().submitConatactCreation();
    }
}
