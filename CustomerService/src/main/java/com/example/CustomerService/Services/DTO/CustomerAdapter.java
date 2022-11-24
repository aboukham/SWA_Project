package com.example.CustomerService.Services.DTO;

import com.example.CustomerService.Domain.Address;
import com.example.CustomerService.Domain.Contact;
import com.example.CustomerService.Domain.Customer;


import org.springframework.stereotype.Component;
@Component
public class CustomerAdapter {
    public void test(){
        System.out.println("Hello");
    }
    public static Customer getCustomer(CustomerDto customerDto){
        Customer customer = new Customer(
                customerDto.getCustomerNum(),
                customerDto.getName(),
                new Address(customerDto.getStreet(), customerDto.getCity(), customerDto.getZip()),
                new Contact(customerDto.getEmailAddress(), customerDto.getPhoneNum())

        );
        return customer;
    }

    public static CustomerDto getCustomerDto(Customer customer){
        CustomerDto customerDto = new CustomerDto(
                customer.getCustomerNum(),
                customer.getName(),
                customer.getContact().getEmailAddress(),
                customer.getContact().getPhone(),
                customer.getAddress().getStreet(),
                customer.getAddress().getCity(),
                customer.getAddress().getZip()
        );
        return customerDto;
    }
}
