package com.viasido.evalqa;

import java.util.ArrayList;

import com.example.handlers.StudentSessionEventHandler;
import com.llsx.pps.PpsManager;
import com.llsx.pps.event.EventManager;
import com.llsx.pps.session.SessionManager;
import com.viasido.evalqa.R;

import Objects.Topic;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class PrivJoin extends Activity {
	public static PpsManager ppsManager; 

	private Button join;

  	private Spinner topicSpin;
  	public static Activity activity;
  	public static ArrayList<String> strTopic;
  	
  	public static Topic t;
	ArrayList<String> ListStudentAnswer = new ArrayList<String>();
	public static ArrayAdapter<String> adp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_priv_join);
		join = (Button) findViewById(R.id.btn_join);
		adp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
		strTopic = new ArrayList<String>();
		topicSpin = (Spinner) findViewById(R.id.priv_topic);
		
		adp = new ArrayAdapter<String>(getApplicationContext(),
				android.R.layout.simple_spinner_item, strTopic);
		activity = this;
		adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		topicSpin.setAdapter(adp);

		join.setOnClickListener(goToQuestion);
		EventManager.getInstance().setEventHandler(new StudentSessionEventHandler());
	}
	
	public static void setTopic(String strTopic1){
		
		strTopic.add(strTopic1);
		adp.notifyDataSetChanged();
		
	}
	
	public static void goToPrivQuestion(Topic topic){
		t=topic;
		
		Intent i = new Intent();
		
		i.setClass(activity, PrivQuestion.class);
						
		ppsManager = new PpsManager(activity, true, PpsManager.SESSION_MODE);
		activity.startActivity(i);
	}
	
	
	/*
	public void selectJoinSession(View v){
		String session = spinChannels.getSelectedItem().toString();
		SessionManager.getInstance().setChosenSession(session);
	}
	*/
	
	
	private void openNextPage(boolean private1) {
		// TODO Auto-generated method stub
		
		Intent intent = new Intent();
		if(private1){
			intent.setClass(getBaseContext(), PrivQuestion.class);
		}else{
			
		}
		
		ppsManager = new PpsManager(this, private1, PpsManager.SESSION_MODE);
		startActivity(intent);
	}
	
	OnClickListener goToQuestion = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			join.setEnabled(false);
			EventManager.getInstance().setEventHandler(new QAEventHandler());
			
			
			/*
			Intent i = new Intent();
			i.setClass(getBaseContext(), PrivQuestion.class);
			
			openNextPage(PpsManager.PRIVATE);
						
			startActivity(i);
			*/
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
