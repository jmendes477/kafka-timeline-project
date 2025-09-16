package com.example.kafkatimeline.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class DataConsumer {

    private final List<Map<String, Object>> dataPoints = new CopyOnWriteArrayList<>();

    @KafkaListener(topics = "timeline-data", groupId = "timeline-group")
    public void consume(String message) {
        String[] parts = message.split(",");
        Map<String, Object> dataPoint = Map.of(
                "time", Long.parseLong(parts[0]),
                "value", Double.parseDouble(parts[1])
        );
        dataPoints.add(dataPoint);
        if (dataPoints.size() > 50) dataPoints.remove(0);
    }

    public List<Map<String, Object>> getDataPoints() {
        return new ArrayList<>(dataPoints);
    }
}
