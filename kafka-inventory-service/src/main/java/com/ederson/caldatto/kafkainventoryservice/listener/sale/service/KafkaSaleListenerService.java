package com.ederson.caldatto.kafkainventoryservice.listener.sale.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ederson.caldatto.kafkainventoryservice.domain.Sale;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaSaleListenerService {

    @KafkaListener(topics = "sales-topic", groupId = "inventory")
    public void listen(Sale sale) {

        log.info("Venda received on module Inventory  {}", sale );

    }

}
