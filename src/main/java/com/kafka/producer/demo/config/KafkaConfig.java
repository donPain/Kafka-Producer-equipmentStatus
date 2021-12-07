package com.kafka.producer.demo.config;

import org.springframework.kafka.support.serializer.JsonSerializer;
import com.kafka.producer.demo.model.EquipamentStatus;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, EquipamentStatus>
    producerFactory()
    {
        Map<String, Object> config
                = new HashMap<>();
        config.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "127.0.0.1:9092");

        config.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);

        config.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        config.put(JsonSerializer.TYPE_MAPPINGS,"equipamentStatus:com.kafka.producer.demo.model.EquipamentStatus");

        return new DefaultKafkaProducerFactory<>(config);

    }

    @Bean
    public KafkaTemplate<String, EquipamentStatus>
    kafkaTemplate()
    {
        return new KafkaTemplate<>(
                producerFactory());
    }
}
