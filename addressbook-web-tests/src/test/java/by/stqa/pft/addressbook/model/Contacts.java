package by.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sony on 30.04.2017.
 */
public class Contacts extends ForwardingSet<NewContactData> {

    private Set<NewContactData> delegate;

    public Contacts() {
        this.delegate = new HashSet<NewContactData>();
    }

    public Contacts(Contacts contact) {
        this.delegate = new HashSet<NewContactData>(contact.delegate);
    }

    @Override
    protected Set<NewContactData> delegate() {
        return delegate;
    }

    public Contacts withAdded(NewContactData contact) {
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts without(NewContactData contact) {
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }
}
