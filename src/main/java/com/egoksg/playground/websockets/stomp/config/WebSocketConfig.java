package com.egoksg.playground.websockets.stomp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry endpointRegistry) {
		endpointRegistry
			.addEndpoint("/gs-guide-websocket") // 엔드포인트를 등록합니다.
				.withSockJS(); // WebSocket을 사용할 수 없는 경우 대체 전송을 사용할 수 있도록 SockJS 폴백 옵션을 활성화합니다.
		endpointRegistry
			.addEndpoint("/ws")
				.setAllowedOriginPatterns("*");
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry brokerRegistry) {
		brokerRegistry
			.setApplicationDestinationPrefixes("/app", "/pub") // @MessageMapping 주석이 달린 메서드에 바인딩된 메시지의 접두사
			// .enableSimpleBroker("/topic", "/sub"); // 접두사가 붙은 대상의 클라이언트에게 메시지를 전달하는 메모리 기반 메시지 브로커
			.enableStompBrokerRelay("/topic", "/sub") // 접두사가 붙은 대상의 클라이언트에게 메시지를 전달하는 외부 메시지 브로커
			.setRelayHost("localhost")
			.setRelayPort(61613)
			.setVirtualHost("/")
			.setClientLogin("guest")
			.setClientPasscode("guest");
	}
	

}
