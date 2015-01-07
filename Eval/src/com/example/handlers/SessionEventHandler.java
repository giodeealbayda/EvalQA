package com.example.handlers;

import com.example.evalqa.SessionActivity;
import com.llsx.pps.event.Event;
import com.llsx.pps.event.EventHandler;

public class SessionEventHandler implements EventHandler{

	@Override
	public void handleEvent(Event event) {
		switch(event.getType()){
		case Event.T_ADD_NEW_SESSION:
				SessionActivity.listChannels.add(event.getSession());
				SessionActivity.channelsAdapter.notifyDataSetChanged();
				break;
		}
		
	}

}
