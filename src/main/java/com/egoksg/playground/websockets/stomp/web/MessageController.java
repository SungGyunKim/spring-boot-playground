package com.egoksg.playground.websockets.stomp.web;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import com.egoksg.playground.websockets.stomp.dto.MessageDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MessageController {
	
	private final SimpMessageSendingOperations simpMessageSendingOperations;
	
	@MessageMapping("/hello2")
	public void message(MessageDto message) {
		simpMessageSendingOperations.convertAndSend("/topic/" + message.getChannelId(), message);
	}
	
}
