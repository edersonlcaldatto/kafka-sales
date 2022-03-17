package com.ederson.caldatto.kafkasalesservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestSendMessageKafka {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send-message")
    public void sendMessage() {
        kafkaTemplate.send("topic-1","Mensagem com kafka.");
    }


}
