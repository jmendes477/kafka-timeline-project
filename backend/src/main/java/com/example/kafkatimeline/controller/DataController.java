package com.example.kafkatimeline.controller;

import com.example.kafkatimeline.consumer.DataConsumer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataConsumer consumer;

    public DataController(DataConsumer consumer) {
        this.consumer = consumer;
    }

    @GetMapping
    public List<Map<String, Object>> getData() {
        return consumer.getDataPoints();
    }
}
