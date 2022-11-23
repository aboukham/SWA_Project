package Integration;

import Domain.Customer;
import Services.DTO.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventSender {
    @Autowired
    KafkaTemplate<String, Customer> kafkaTemplate;
    public void send(String topic, Customer customer){
        kafkaTemplate.send(topic, customer);
    }
}
