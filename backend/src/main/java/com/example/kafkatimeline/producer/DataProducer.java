package com.example.kafkatimeline.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DataProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topicName;

    public DataProducer(KafkaTemplate<String, String> kafkaTemplate,
                        @Value("${app.kafka.topic}") String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(topicName, message);
    }
}
