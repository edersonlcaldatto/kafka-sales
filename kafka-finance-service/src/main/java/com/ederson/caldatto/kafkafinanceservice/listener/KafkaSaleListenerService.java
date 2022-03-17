package com.ederson.caldatto.kafkafinanceservice.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ederson.caldatto.kafkafinanceservice.domain.Sale;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaSaleListenerService {

    @KafkaListener(topics = "sales-topic", groupId = "finance")
    public void listen(Sale sale) {

        log.info("Venda received on module Finance {}", sale );

    }

}
