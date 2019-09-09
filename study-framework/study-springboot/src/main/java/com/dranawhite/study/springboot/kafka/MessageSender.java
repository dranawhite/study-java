package com.dranawhite.study.springboot.kafka;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author dranawhite
 * @version : MessageSender.java, v 0.1 2019-09-05 14:25 dranawhite Exp $$
 */
@KafkaSender
@Slf4j
public class MessageSender {

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public void sendMessage(String topic, Message msg) {
        kafkaTemplate.send(topic, msg);
        log.info("Send Message [{}]", msg);
    }

}
