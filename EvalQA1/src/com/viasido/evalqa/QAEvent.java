package com.viasido.evalqa;

import com.llsx.pps.event.Event;

public class QAEvent extends Event{

	public QAEvent(String recipient, int type, String payload){
		super(recipient, type, payload);
	}
	
	public static final int START_QUIZ = 0;
	public static final int NEXT_QUESTION = 1;
	public static final int FINISH_QUESTION = 2;
	
	public static final int RECEIVE_ANS = 3;
	public static final int SEND_ANS = 4;
	
	
}
