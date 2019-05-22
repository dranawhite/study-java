package com.study.boot.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @EnableWebSocketMessageBroker注解开启使用STOMP协议来传输基于代理message broker的消息
 *
 * @author dranawhite
 * @version : WebSocketConfig.java, v 0.1 2019-05-22 15:26 dranawhite Exp $$
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        // 注册STOMP协议的节点（endpoint），并映射到指定的URL，指定使用SockJS协议
        stompEndpointRegistry.addEndpoint("/gs-guide-websocket").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
        // 配置消息代理Message Broker，广播式配置一个/topic消息代理
        messageBrokerRegistry.enableSimpleBroker("/topic");
        messageBrokerRegistry.setApplicationDestinationPrefixes("/websocket");
    }
}
