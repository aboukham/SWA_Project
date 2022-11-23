package Controller;

import Domain.Customer;
import Services.CustomerService;
import Services.DTO.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/{customerNum}")
    public ResponseEntity<?> get(@PathVariable String customerNum){
        CustomerDto customerDto = customerService.getCustomer(customerNum);
        System.out.println("the customer is :" + customerDto);
        return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CustomerDto customerDto){
        customerService.addCustomer(customerDto);
        System.out.println("the customer is added");
        return new ResponseEntity<Customer>(HttpStatus.OK);
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
