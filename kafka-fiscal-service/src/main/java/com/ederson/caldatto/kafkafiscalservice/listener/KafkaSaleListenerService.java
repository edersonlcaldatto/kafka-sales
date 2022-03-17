package com.ederson.caldatto.kafkafiscalservice.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ederson.caldatto.kafkafiscalservice.domain.Sale;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaSaleListenerService {

    @KafkaListener(topics = "sales-topic", groupId = "fiscal")
    public void listen(Sale sale) {

        log.info("Venda received on module Fiscal {}", sale );

    }

}
