package com.example.kafkatimeline.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DataProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Random random = new Random();

    public DataProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 1000)
    public void produceData() {
        long timestamp = System.currentTimeMillis();
        double value = 50 + random.nextDouble() * 50;
        String message = timestamp + "," + value;
        kafkaTemplate.send("timeline-data", message);
        System.out.println("Produced: " + message);
    }
}
