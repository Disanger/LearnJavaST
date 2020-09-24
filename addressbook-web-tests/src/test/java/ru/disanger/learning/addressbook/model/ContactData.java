package ru.disanger.learning.addressbook.model;

public class ContactData {
    private int contactID;
    private final String contactName;
    private final String contactSurname;
    private final String contactPhoneHome;
    private final String contactEmail;
    private String group;

    public ContactData(String contactName, String contactSurname, String contactPhoneHome, String contactEmail, String group) {
        this.contactID = Integer.MAX_VALUE;
        this.contactName = contactName;
        this.contactSurname = contactSurname;
        this.contactPhoneHome = contactPhoneHome;
        this.contactEmail = contactEmail;
        this.group = group;
    }

    public ContactData(int contactID, String contactName, String contactSurname, String contactPhoneHome, String contactEmail, String group) {
        this.contactID = contactID;
        this.contactName = contactName;
        this.contactSurname = contactSurname;
        this.contactPhoneHome = contactPhoneHome;
        this.contactEmail = contactEmail;
        this.group = group;
    }

    public int getContactID() {
        return contactID;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactSurname() {
        return contactSurname;
    }

    public String getContactPhoneHome() {
        return contactPhoneHome;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (contactName != null ? !contactName.equals(that.contactName) : that.contactName != null) return false;
        return contactSurname != null ? contactSurname.equals(that.contactSurname) : that.contactSurname == null;
    }

    @Override
    public int hashCode() {
        int result = contactName != null ? contactName.hashCode() : 0;
        result = 31 * result + (contactSurname != null ? contactSurname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "groupID='" + contactID + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactSurname='" + contactSurname + '\'' +
                '}';
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }
}