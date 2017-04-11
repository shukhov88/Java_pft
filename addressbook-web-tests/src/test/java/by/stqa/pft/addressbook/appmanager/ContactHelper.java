package by.stqa.pft.addressbook.appmanager;

import by.stqa.pft.addressbook.model.GroupData;
import by.stqa.pft.addressbook.model.NewContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(NewContactData newContactData, boolean creation) {
        type(By.name("firstname"), newContactData.getFirstName());
        type(By.name("lastname"), newContactData.getLastName());
        type(By.name("address"), newContactData.getAddress());
        type(By.name("mobile"), newContactData.getMobilePhone());
        type(By.name("email"), newContactData.getEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(newContactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void goToNewContactPage() {
        if (wd.findElement(By.cssSelector("h1")).getText().equals("Edit / add address book entry")) {
            return;
        }
        click(By.linkText("add new"));
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void initContactModification(int index) {
        wd.findElements(By.cssSelector("[title=Edit]")).get(index).click();;
    }

    public void submitContactModification() {
        click(By.cssSelector("[name=update]:nth-child(1)"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void createContact(NewContactData contact, boolean group) {
        goToNewContactPage();
        fillContactForm(contact, group);
        submitContactCreation();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<NewContactData> getContactsList() {
        List<NewContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("[name=entry]"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            NewContactData contact = new NewContactData(id, firstName, lastName, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
