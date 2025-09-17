package com.example.kafkatimeline.producer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ScheduledDataProducer {

    private final DataProducer producer;
    private final Random random = new Random();

    public ScheduledDataProducer(DataProducer producer) {
        this.producer = producer;
    }

    // Send a random message every 1 second
    @Scheduled(fixedRate = 1000)
    public void sendRandomData() {
        int value = 10 + random.nextInt(90); // random number 10-99
        String message = String.valueOf(value);
        producer.sendMessage(message);
        System.out.println("Produced message: " + message);
    }
}
