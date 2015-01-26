package com.viasido.evalqa;

import Objects.Topic;
import android.util.Log;

import com.llsx.pps.event.Event;
import com.llsx.pps.event.EventHandler;

public class QAEventHandler implements EventHandler {

	@Override
	public void handleEvent(Event event) {
		// TODO Auto-generated method stub
		
		Log.e("Test", "A");
		switch(event.getType()){
		case QAEvent.START_QUIZ:
			Log.e("Start quiz", "Start quiz");
			PrivJoin.goToPrivQuestion((Topic) event.getPayload());
			Topic t = (Topic) event.getPayload();
			Log.e("topic", t.getTitle());
			break;
		case QAEvent.NEXT_QUESTION:
			Log.e("Next question", "Next question");
			break;
		case QAEvent.FINISH_QUESTION:
			Log.e("Finish", "Finish");
			break;
		}
	}

	
}
