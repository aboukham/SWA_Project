package com.example.CustomerService.Controller;

import com.example.CustomerService.Services.CustomerService;
import com.example.CustomerService.Services.DTO.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/{customerNum}")
    public ResponseEntity<?> get(@PathVariable String customerNum){
        CustomerDto customerDto = customerService.getCustomer(customerNum);
        System.out.println("the customer is :" + customerDto);
        return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<?> add(@RequestBody CustomerDto customerDto){
        customerService.addCustomer(customerDto);
        System.out.println("the customer is added");
        return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.OK);
    }
    @PutMapping("/{customerNum}")
    public ResponseEntity<?> update(@PathVariable String customerNum, @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerNum, customerDto);
        System.out.println("the customer is updated");
        return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.OK);
    }

    @DeleteMapping("/{customerNum}")
    public ResponseEntity<?> delete(@PathVariable String customerNum){
        customerService.deleteCustomer(customerNum);
        System.out.println("the customer is deleted");
        return new ResponseEntity<CustomerDto>(HttpStatus.OK);
    }
}
