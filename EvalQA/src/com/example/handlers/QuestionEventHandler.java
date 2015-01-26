package com.example.handlers;

import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Toast;


import com.llsx.pps.PpsManager;
import com.llsx.pps.event.Event;
import com.llsx.pps.event.EventHandler;

public class QuestionEventHandler implements EventHandler {

	@Override
	public void handleEvent(final Event event) {
		Log.e("Handling CardGameEvent", "Type: "+event.getType() + "Recipient:" + event.getRecipient());
		switch(event.getType())
		{
		case QuestionEvent.SELECT_ANSWER:
			Log.e("Select answer", "select answer");
//			PlayPersonalActivity.respondDrawRequest(event.getPayload().toString());
			break;
		
		case Event.T_USER_JOIN_PRIVATE:
			Log.e("USER_JOIN_PRIVATE","pasok");
			break;
			
		case Event.T_USER_JOIN_PUBLIC:
			Log.e("USER_JOIN_PUBLIC","pasok");
			break;
			
		case Event.T_USER_LEFT_PRIVATE:
			Log.e("USER_LEFT_PRIVATE","pasok");
			break;
			
		case Event.T_USER_LEFT_PUBLIC:
			Log.e("USER_LEFT_PUBLIC","pasok");
			break;
		}
		
	}
	
	public void setTurn(final Boolean isTurn) {
		if(isTurn) {
			//buffer of 500miliseconds for the slight delay in receiving
			 new CountDownTimer(3500, 1000) {

				
			     public void onTick(long millisUntilFinished) {
//     				 PlayPersonalActivity.txtTurn.setText("Is it your turn? " + millisUntilFinished / 1000);
			     }

			     public void onFinish() {
//			    	 PlayPersonalActivity.turn = isTurn;
//			    	 PlayPersonalActivity.txtTurn.setText("Is it your turn? Yes");
			     }

			  }.start();
		}else {
			/*
			PlayPersonalActivity.turn = isTurn;
			PlayPersonalActivity.txtTurn.setText("Is it your turn? No");
			*/
		}
	}

}
