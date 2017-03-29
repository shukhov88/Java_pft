package by.stqa.pft.addressbook.model;

public class NewContactData {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String mobilePhone;
    private final String email;
    private String group;

    public NewContactData(String firstName, String lastName, String address, String mobilePhone, String email, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getAddress() {
        return address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }


    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }
}
