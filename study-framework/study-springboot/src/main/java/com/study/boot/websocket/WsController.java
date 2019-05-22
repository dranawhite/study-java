package com.study.boot.websocket;

import com.dranawhite.common.common.ThreadUnit;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 *
 * 访问localhost:8080/websocket.html
 *
 * @author dranawhite
 * @version : WsController.java, v 0.1 2019-05-22 15:49 dranawhite Exp $$
 */
@Controller
public class WsController {

    @MessageMapping("/welcome")
    @SendTo("/topic/greetings")
    public SocketResponse say(SocketRequest request) {
        SocketResponse response = new SocketResponse();
        response.setResponse("Welcome WebSocket! " + request.getName());
        ThreadUnit.sleep(10);
        return response;
    }
}
