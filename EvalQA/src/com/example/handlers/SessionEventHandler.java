package com.example.handlers;

import android.util.Log;

import com.viasido.evalqa.SessionActivity;
import com.llsx.pps.event.Event;
import com.llsx.pps.event.EventHandler;

public class SessionEventHandler implements EventHandler{

	@Override
	public void handleEvent(Event event) {
		Log.e("A", "A");
		switch(event.getType()){
		case Event.T_ADD_NEW_SESSION:
				//SessionActivity.spinChannels.
				SessionActivity.listChannels.add(event.getSession());
				SessionActivity.channelsAdapter.notifyDataSetChanged();
				break;
		}
		
	}

}
