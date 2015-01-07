package com.example.evalqa;

import java.util.ArrayList;

import com.llsx.pps.session.SessionManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PrivJoin extends Activity {
	
	private Button join;
	ArrayList<String> ListStudentAnswer = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_priv_join);
		join = (Button) findViewById(R.id.btn_join);
		join.setOnClickListener(goToQuestion);
	}
	
	/*
	public void selectJoinSession(View v){
		String session = spinChannels.getSelectedItem().toString();
		SessionManager.getInstance().setChosenSession(session);
	}
	*/
	
	
	OnClickListener goToQuestion = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i = new Intent();
			i.setClass(getBaseContext(), PrivQuestion.class);
			
			//
			
			
			startActivity(i);
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.priv_join, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
