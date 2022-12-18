package com.egoksg.playground.websockets.stomp.listener;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Component
public class WebSocketListener {

	private final SimpMessageSendingOperations sendingOperations;
	
	@EventListener
	public void handleWebSocketConnectListener(SessionConnectEvent event) {
		log.info("Socket Connect : {}", event.getMessage().toString());
	}
	
	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		log.info("Socket Disconnect : {}", event.getMessage().toString());
	}
	
}
