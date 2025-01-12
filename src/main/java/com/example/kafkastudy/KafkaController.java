package com.example.kafkastudy;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class KafkaController {
    private final KafkaProducer kafkaProducer;
    private final KafkaConsumer kafkaConsumer;

    @PostMapping("/kafka/send")
    public String sendMessage(@RequestParam String message) throws Exception {
        try {
            kafkaProducer.sendMessage(message);

            return "success";
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @GetMapping("/kafka/get")
    public List<String> getMessage() {
        return kafkaConsumer.getAllMessage();
    }
}
