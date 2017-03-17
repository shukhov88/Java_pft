package by.stqa.pft.addressbook.appmanager;

import by.stqa.pft.addressbook.model.NewContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper extends BaseHelper {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void fillContactForm(NewContactData newContactData) {
        type(By.name("firstname"), newContactData.getFirstName());
        type(By.name("middlename"), newContactData.getMiddleName());
        type(By.name("lastname"), newContactData.getLastName());
        type(By.name("nickname"), newContactData.getNickName());
        type(By.name("title"), newContactData.getTitle());
        type(By.name("address"), newContactData.getAddress());
        click(By.name("theform"));
        type(By.name("mobile"), newContactData.getMobilePhone());
        type(By.name("work"), newContactData.getWorkPhone());
        type(By.name("email"), newContactData.getEmail());
    }

    public void goToNewContactPage() {
        click(By.linkText("add new"));
    }

    public void submitConatactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }
}
