package com.example.ReviewService.Integration;

import com.example.ReviewService.Domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventSender {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    public void send(String topic, String review){
        kafkaTemplate.send(topic, review);
    }
}
