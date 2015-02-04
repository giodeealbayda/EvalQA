package com.viasido.evalqa;

import android.util.Log;

import com.llsx.pps.event.Event;
import com.llsx.pps.event.EventHandler;

public class StudentSessionEventHandler implements EventHandler{

	@Override
	public void handleEvent(Event event) {
		// TODO Auto-generated method stub
		
		Log.e("ssevent", "ssevent");
		switch(event.getType()){
		case Event.T_ADD_NEW_SESSION:
			
			Log.e("HERE", event.getSession());	
			PubPrivCreateTopic.setTopic(event.getSession());

			break;
		}
	}

}
