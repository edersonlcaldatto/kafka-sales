package com.ederson.caldatto.kafkasalesservice.config;

import java.io.Serializable;
import java.util.HashMap;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaProducerConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public ProducerFactory<String, String> producerFactory() {

        var configs = new HashMap<String, Object>();

        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    public KafkaTemplate<String,String> kafkaTemplate() {

        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ProducerFactory<String, Object> objectProducerFactory() {

        var configs = new HashMap<String, Object>();

        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(configs, new StringSerializer(), new JsonSerializer<>());
    }

    @Bean
    public KafkaTemplate<String, Serializable> objectKafkaTemplate() {

        return new KafkaTemplate(objectProducerFactory());
    }


//    @Bean
//    public KafkaAdmin kafkaAdmin() {
//
//        var config = new HashMap<String, Object>();
//        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
//
//        return new KafkaAdmin(config);
//    }
//
//    @Bean
//    public NewTopic topic() {
//        return new NewTopic("topic-1", 5, Short.valueOf("1") );
//    }

    @Bean
    public KafkaAdmin.NewTopics topics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("topic-1").partitions(2).replicas(1).build(),
                TopicBuilder.name("sales-topic").partitions(2).build()
        );
    }
}
