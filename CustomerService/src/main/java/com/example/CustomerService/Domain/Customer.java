package com.example.CustomerService.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {
    @Id
    private String  customerNum;
    private String  name;
    private Address address;
    private Contact contact;

    public Customer(String customerNum, String name, Address address, Contact contact) {
        this.customerNum = customerNum;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public String getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(String customerNum) {
        this.customerNum = customerNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNum='" + customerNum + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", contact=" + contact +
                '}';
    }
}
