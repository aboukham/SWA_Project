package com.example.BooksCommandService.Integration;

import com.example.BooksCommandService.Domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventSender {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    public void send(String topic, String book){
        kafkaTemplate.send(topic, book);
    }
}
