package com.example.kafkatimeline.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class DataConsumer {

    private final List<Map<String, Object>> dataPoints = new LinkedList<>();

    @KafkaListener(topics = "${app.kafka.topic}", groupId = "timeline-group")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);

        // Store the message with a timestamp
        dataPoints.add(Map.of(
                "timestamp", Instant.now().toString(),
                "value", message
        ));

        // Optional: Keep only the last N messages (to avoid unbounded memory use)
        if (dataPoints.size() > 1000) {
            dataPoints.remove(0);
        }
    }

    // Expose consumed messages for the REST controller
    public List<Map<String, Object>> getDataPoints() {
        return Collections.unmodifiableList(dataPoints);
    }
}
