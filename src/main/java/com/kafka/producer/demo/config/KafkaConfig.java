package com.kafka.producer.demo.config;

import com.kafka.producer.demo.model.EquipmentStatus;
import com.kafka.producer.demo.model.Kijo;
import org.springframework.kafka.support.serializer.JsonSerializer;
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
    public ProducerFactory<String, EquipmentStatus>
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
        config.put(JsonSerializer.TYPE_MAPPINGS,"EquipmentStatus:com.kafka.producer.demo.model.EquipmentStatus");

        return new DefaultKafkaProducerFactory<>(config);

    }
    @Bean
    public ProducerFactory<String, Kijo>
    producerKijo()
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
        config.put(JsonSerializer.TYPE_MAPPINGS,"Kijo:com.kafka.producer.demo.model.Kijo");

        return new DefaultKafkaProducerFactory<>(config);

    }

    @Bean
    public KafkaTemplate<String, EquipmentStatus>
    kafkaTemplate()
    {
        return new KafkaTemplate<>(
                producerFactory());
    }
    @Bean
    public KafkaTemplate<String, Kijo>
    kijoProducerTemplate()
    {
        return new KafkaTemplate<>(
                producerKijo());
    }
}
