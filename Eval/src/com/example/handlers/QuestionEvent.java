package com.example.handlers;

import com.llsx.pps.event.Event;

public class QuestionEvent extends Event {
	public QuestionEvent(String recipient, int type, String payload) {
		super(recipient, type, payload);
	}
	
	public static final int SELECT_ANSWER = 0;	
	
}
