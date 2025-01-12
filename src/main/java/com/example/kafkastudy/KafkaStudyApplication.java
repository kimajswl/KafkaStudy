package com.example.kafkastudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class KafkaStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaStudyApplication.class, args);
    }

}
