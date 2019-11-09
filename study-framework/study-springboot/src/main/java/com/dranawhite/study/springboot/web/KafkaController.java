package com.dranawhite.study.springboot.web;

import com.dranawhite.common.model.DranaResponse;
import com.dranawhite.common.uuid.UUIDUtil;
import com.dranawhite.study.springboot.kafka.Message;
import com.dranawhite.study.springboot.kafka.MessageSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dranawhite
 * @version : KafkaController.java, v 0.1 2019-09-05 14:27 dranawhite Exp $$
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private MessageSender messageSender;

    @GetMapping("/send")
    public DranaResponse<Boolean> sendMessage() {
        Message msg = new Message();
        msg.setId(UUIDUtil.getRandomUUID());
        msg.setMessage("Hello Kafka!");
        messageSender.sendMessage("TOPIC-TEST", msg);
        return DranaResponse.success(Boolean.TRUE);
    }
}
