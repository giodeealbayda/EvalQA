package com.viasido.evalqa;

import java.util.ArrayList;

import Objects.Answer;
import Objects.Question;
import Objects.Topic;
import android.app.AlertDialog;
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
			PrivQuestion.receiveTopic((Topic) event.getPayload());
			break;
		case QAEvent.NEXT_QUESTION:
			Log.e("Next question", "Next question");
			Question q = (Question) event.getPayload();	
			PrivQuestion.nextQuestion(q);
			break;
		case QAEvent.FINISH_QUESTION:
			Log.e("Finish", "Finish");
			AlertDialog.Builder builder = new AlertDialog.Builder(PrivQuestion.activity);
			builder.setTitle("Finish");
			builder.show();
			break;
		case QAEvent.RECEIVE_ANS:
			break;
		case QAEvent.SEND_ANS:
			
			Log.e("ANSWER"+event.getPayload().toString(), "ANSWER"+event.getPayload().toString());
			String payload = event.getPayload().toString();
			String[] ans = payload.split("-");
			
			PubStudentList.checkAns(ans[0], ans[1]);
			// check if correct
			break;
		}
	}

	
}
