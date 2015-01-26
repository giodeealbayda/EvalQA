package com.example.handlers;

import android.util.Log;

import com.llsx.pps.event.Event;
import com.llsx.pps.event.EventHandler;
import com.viasido.evalqa.PrivJoin;
import com.viasido.evalqa.SessionActivity;

public class StudentSessionEventHandler implements EventHandler{

	@Override
	public void handleEvent(Event event) {
		// TODO Auto-generated method stub
		
		
		switch(event.getType()){
		case Event.T_ADD_NEW_SESSION:
			
			Log.e("HI", "HI");
			Log.e("HERE", event.getSession());	
			
		//	PrivJoin pj = new PrivJoin();
			PrivJoin.setTopic(event.getSession());

				break;
		}
	}

}
