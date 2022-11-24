package com.example.CustomerService.Domain;

public class Contact {
    private String  emailAddress;
    private String  phone;

    public Contact(String emailAddress, String phone) {
        this.emailAddress = emailAddress;
        this.phone = phone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhone() {
        return phone;
    }
}
