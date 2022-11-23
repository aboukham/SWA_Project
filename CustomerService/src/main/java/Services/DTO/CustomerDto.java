package Services.DTO;

import org.springframework.data.mongodb.core.mapping.Document;

public class CustomerDto {
    private int  customerNum;
    private String  name;
    private String  emailAddress;
    private String  phoneNum;
    private String  street;
    private String  city;
    private String  zip;

    public CustomerDto(int customerNum, String name, String emailAddress, String phoneNum, String street, String city, String zip) {
        this.customerNum = customerNum;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNum = phoneNum;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public int getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(int customerNum) {
        this.customerNum = customerNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerNum='" + customerNum + '\'' +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
