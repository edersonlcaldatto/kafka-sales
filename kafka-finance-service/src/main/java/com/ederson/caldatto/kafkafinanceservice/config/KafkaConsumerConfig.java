package com.ederson.caldatto.kafkafinanceservice.config;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableKafka
@Component
public class KafkaConsumerConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    public ConsumerFactory jsonConsumerFactory() {

        var config = new HashMap<String, Object>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory kafkaListenerContainerFactory() {
        var factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(jsonConsumerFactory());
        factory.setMessageConverter(new JsonMessageConverter());
        return factory;
    }

}
