package com.example.kafkatimeline.controller;

import com.example.kafkatimeline.consumer.DataConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DataController {

    private final DataConsumer consumer;

    public DataController(DataConsumer consumer) {
        this.consumer = consumer;
    }

    @GetMapping("/api/data")
    public List<Map<String, Object>> getData() {
        return consumer.getDataPoints();
    }
}
