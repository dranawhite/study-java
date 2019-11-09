package com.dranawhite.study.springboot.web;

import com.dranawhite.common.common.ThreadUnit;
import com.dranawhite.common.model.DranaRequest;
import com.dranawhite.common.model.DranaResponse;
import com.dranawhite.study.springboot.model.user.UserVO;

import lombok.extern.slf4j.Slf4j;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 访问localhost:8080/study-springboot/websocket/websocket.html
 *
 * @author dranawhite
 * @version : WsController.java, v 0.1 2019-05-22 15:49 dranawhite Exp $$
 */
@RestController
@RequestMapping("/websocket")
@Slf4j
public class WebSocketController {

    @MessageMapping("/welcome")
    @SendTo("/topic/greetings")
    public DranaResponse<String> sayHello(@Payload DranaRequest<UserVO> request) {
        UserVO user = request.getData();
        String msg = "Welcome to WebSocket! " + user.getName();
        log.info(msg);
        // 模拟耗时
        ThreadUnit.sleep(10);
        return DranaResponse.success(msg);
    }
}
