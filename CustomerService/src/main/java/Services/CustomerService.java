package Services;

import Domain.Customer;
import Integration.EventSender;
import Repository.CustomerRepository;
import Services.DTO.CustomerAdapter;
import Services.DTO.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EventSender eventSender;


    public void addCustomer(CustomerDto customerDto){
        Customer    customer = CustomerAdapter.getCustomer(customerDto);
        eventSender.send("creation topic", customer);
        customerRepository.save(customer);
    }

    public CustomerDto getCustomer(String customerNum){
        Optional<Customer> result = customerRepository.findById(customerNum);
        if (result.isPresent()){
            return CustomerAdapter.getCustomerDto(result.get());
        }else
            return null;

    }

    public void updateCustomer(String customerNum, CustomerDto customerDto){
        Customer customer = CustomerAdapter.getCustomer(customerDto);
        Optional<Customer> result = customerRepository.findById(customerNum);
        if (result.isPresent()) {
            eventSender.send("updating topic", customer);
            customerRepository.save(customer);
        }

    }

    public void deleteCustomer(String customerNum){
        Optional<Customer> result = customerRepository.findById(customerNum);
        if (result.isPresent()) {
            eventSender.send("Deletion topic", result.get());
            customerRepository.delete(result.get());
        }
    }

}
