package ru.disanger.learning.addressbook.model;

public class ContactData {
    private final String contactName;
    private final String contactSurname;
    private final String contactPhoneHome;
    private final String contactEmail;

    public ContactData(String contactName, String contactSurname, String contactPhoneHome, String contactEmail) {
        this.contactName = contactName;
        this.contactSurname = contactSurname;
        this.contactPhoneHome = contactPhoneHome;
        this.contactEmail = contactEmail;
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
}