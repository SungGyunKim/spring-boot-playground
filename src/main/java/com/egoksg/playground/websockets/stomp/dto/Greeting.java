package com.egoksg.playground.websockets.stomp.dto;

public class Greeting {

	private String content;
	
	public Greeting() {
		
	}
	
	public Greeting(String content) {
		this.content = content;
	}
	
	public String getContent() {
	  return content;
	}

}