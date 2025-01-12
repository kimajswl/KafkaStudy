package com.example.kafkastudy;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer {
    List<String> allMessage = new ArrayList<>();

    @KafkaListener(topics = "topic1", groupId = "${spring.kafka.consumer.group-id}", concurrency = "2")
    public void listen(ConsumerRecord<String, String> record) {
        record.value();
        System.out.println("받은 메시지" + record.value());

        allMessage.add(record.value());
    }

    public List<String> getAllMessage() {
        return allMessage;
    }
}
