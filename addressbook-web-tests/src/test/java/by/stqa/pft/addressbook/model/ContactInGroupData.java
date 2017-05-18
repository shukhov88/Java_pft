package by.stqa.pft.addressbook.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address_in_groups")
public class ContactInGroupData {

    @Id
    @Column(name = "group_id")
    private int id;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ContactInGroupData{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactInGroupData that = (ContactInGroupData) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
