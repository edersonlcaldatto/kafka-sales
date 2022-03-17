package com.ederson.caldatto.kafkasalesservice.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ederson.caldatto.kafkasalesservice.domain.Sale;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SaleService {

    @Autowired
    private KafkaTemplate<String, Serializable> objectKafkaTemplate;

    public Sale save(Sale sale)  {

        try {
            var record = objectKafkaTemplate.send("sales-topic",sale).get().getRecordMetadata();
            log.info("Message send to Partition {} and offset {} ", record.partition(), record.offset());

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error to proceduce Message");
        }

        return sale;

    }
}
