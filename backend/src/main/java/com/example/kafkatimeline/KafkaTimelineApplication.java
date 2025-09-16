package com.example.kafkatimeline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaTimelineApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaTimelineApplication.class, args);
    }
}
