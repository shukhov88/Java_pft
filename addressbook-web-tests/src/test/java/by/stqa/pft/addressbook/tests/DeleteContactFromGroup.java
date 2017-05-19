package by.stqa.pft.addressbook.tests;


import by.stqa.pft.addressbook.model.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactFromGroup extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().mainPage();
            app.contact().create(new ContactData().withFirstName("t").withLastName("tr").
                    withAddress("tre").withMobilePhone("qwe").withEmail("qwert"));
        }
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
            app.goTo().mainPage();
        }
        if (app.db().groupsWithContact().size() == 0) {
            Contacts contacts = app.db().contacts();
            Groups groups = app.db().groups();
            app.contact().addToGroup(contacts.iterator().next(), groups.iterator().next());
            app.goTo().mainPage();
        }
    }

    @Test
    public void testDeleteContactFromGroup() throws InterruptedException {
        Groups list = app.db().groups();
        ListOfContactsInGroup before = app.db().groupsWithContact();
        ContactInGroupData toDelete = before.iterator().next();
        app.contact().removeFromGroup(list, toDelete);

        //Если запустить тест без sleep(), то ассерт упадет.
        //Похоже на то, что привязка контакта к группе в БД удаляется медленнее, чем приходит запрос на получение списка after.
        //То есть на момент запросв списка after контакт из группы в БД еще не удален.
        //На домашнем компе (там не иксамп, а руками развернутый локал сервер) такой проблемы нет...
        //Как эту проблему можно решить правильнее?
        Thread.sleep(500);
        ListOfContactsInGroup after = app.db().groupsWithContact();

        System.out.println("before: " + before.without(toDelete));
        System.out.println("after: " + after);

        assertThat(after, equalTo(before.without(toDelete)));
    }
}
