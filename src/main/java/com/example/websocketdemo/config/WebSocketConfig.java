package com.example.websocketdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker //habilita servidor websocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override                                                          //o stomp é um framework do spring
    public void registerStompEndpoints(StompEndpointRegistry registry) { //endpoint que o cliente usa pra conectar ao websocket
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) { //roteia mensagens de um cliente para o outro
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
}