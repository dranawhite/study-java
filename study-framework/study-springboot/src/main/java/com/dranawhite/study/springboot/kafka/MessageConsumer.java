package com.dranawhite.study.springboot.kafka;

import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * @author dranawhite
 * @version : MessageConsumer.java, v 0.1 2019-09-05 14:30 dranawhite Exp $$
 */
@KafkaConsumer
@Slf4j
public class MessageConsumer {

    @KafkaListener(id = "TEST", topics = {"TOPIC-TEST"})
    public void listenMessage(@Payload Message message) {
        log.info("Receive Message [{}]", message);
    }
}
