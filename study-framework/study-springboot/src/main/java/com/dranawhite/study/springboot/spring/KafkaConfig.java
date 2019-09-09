package com.dranawhite.study.springboot.spring;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dranawhite
 * @version : KafkaConfig.java, v 0.1 2019-09-05 13:52 dranawhite Exp $$
 */
@EnableKafka
@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<Object, Object> producerFactory() {
        Map<String, Object> configs = new HashMap<>(16);
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configs.put(ProducerConfig.RETRIES_CONFIG, 3);
        configs.put(ProducerConfig.BATCH_SIZE_CONFIG, 1000);
        configs.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        configs.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 1024 * 1024);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    public KafkaTemplate<Object, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory(), true);
    }

    @Bean
    public ConsumerFactory<Object, Object> consumerFactory() {
        Map<String, Object> configs = new HashMap<>(16);
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, 0);
        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        configs.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 1000);
        configs.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 30000);
        configs.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 100);
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configs.put(JsonDeserializer.TRUSTED_PACKAGES, "com.dranawhite.study.springboot.kafka");
        return new DefaultKafkaConsumerFactory<>(configs);
    }

    @Bean
    public KafkaListenerContainerFactory<?> batchContainerFactory() {
        ConcurrentKafkaListenerContainerFactory containerFactory = new ConcurrentKafkaListenerContainerFactory();
        containerFactory.setConsumerFactory(consumerFactory());
        containerFactory.setConcurrency(4);
        containerFactory.setBatchListener(true);
        containerFactory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        return containerFactory;
    }
}
