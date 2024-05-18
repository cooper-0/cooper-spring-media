package com.whisper.coopermedia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/signaling") // webSokcet 접속시 endpoint 설정
                .setAllowedOriginPatterns("http://localhost:3000", "http://221.144.190.76:3000") // cors 에 따른 설정 ( * 는 모두 허용 )
                .withSockJS(); // 브라우저에서 WebSocket을 지원하지 않는 경우에 대안으로 어플리케이션의 코드를 변경할 필요 없이 런타임에 필요할 때 대체하기 위해 설정
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // broker url 설정, 메시지 받을 떄
        config.setApplicationDestinationPrefixes("/app"); // send url 설정, 메시지 보낼 때
    }
}
