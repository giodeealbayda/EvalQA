package com.viasido.evalqa;

import java.util.ArrayList;
import java.util.HashMap;

import Objects.Topic;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.llsx.pps.PpsManager;
import com.llsx.pps.event.EventManager;
import com.llsx.pps.session.SessionManager;

public class PubPrivCreateTopic extends Activity {

	//public
	private Button startBtn;
	private Spinner topicSpinner;
	private ArrayList<Topic> topics;
	private Topic selectedTopic;
	private LinearLayout pubScreenLayout;
	
	
	//private
	private Button join;
  	private Spinner topicSpin;
  	public static ArrayList<String> strTopic;
  	public static Topic t;
	ArrayList<String> ListStudentAnswer = new ArrayList<String>();
	public static ArrayAdapter<String> adp;
	private LinearLayout privScreenLayout;
	
  	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pub_priv_create_topic);
		
		pubScreenLayout = (LinearLayout) findViewById(R.id.pubscreen);
		privScreenLayout = (LinearLayout) findViewById(R.id.privscreen);
		
		if(PpsManager.getInstance().isPrivate()) {
			pubScreenLayout.setVisibility(View.GONE);
			privScreenLayout.setVisibility(View.VISIBLE);
			join = (Button) findViewById(R.id.btn_join);
			adp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
			strTopic = new ArrayList<String>();
			topicSpin = (Spinner) findViewById(R.id.priv_topic);
			
			adp = new ArrayAdapter<String>(getApplicationContext(),
					R.layout.list_item, strTopic);

			adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			topicSpin.setAdapter(adp);

			join.setOnClickListener(goToQuestion);
			
		}
		else if(!PpsManager.getInstance().isPrivate()) {
			pubScreenLayout.setVisibility(View.VISIBLE);
			privScreenLayout.setVisibility(View.GONE);
			
			topics = new ArrayList<Topic>();
			selectedTopic = new Topic(null);
			ArrayList<String> topiclist = new ArrayList<String>();
			startBtn = (Button) findViewById(R.id.start_btn);
			startBtn.setOnClickListener(goToStudentList);
			topicSpinner = (Spinner) findViewById(R.id.pub_topic);
			
			Topic math = (Topic) getIntent().getSerializableExtra("math");
			Topic fil = (Topic) getIntent().getSerializableExtra("fil");
			Topic eng = (Topic) getIntent().getSerializableExtra("eng");
			topics.add(math);
			topics.add(fil);
			topics.add(eng);
			
			for(int i = 0; i < topics.size(); i++)
			{
				topiclist.add(topics.get(i).toString());
			}
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), R.layout.list_item, topiclist);
			topicSpinner.setAdapter(adapter);
		}
	
		EventManager.getInstance().setEventHandler(new StudentSessionEventHandler());
		
	}

	@Override
	protected void onPause(){
		super.onPause();
		PpsManager.getInstance().stop();
	}
	
	@Override
	protected void onResume(){
		super.onResume();	
		PpsManager.getInstance().setSessionMode(PpsManager.SESSION_MODE);
		PpsManager.getInstance().start();
	}
	
	OnClickListener goToStudentList = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			
			Intent i = new Intent();
			i.setClass(getBaseContext(), PubStudentList.class);
			selectedTopic = getSelectedTopic();
			i.putExtra("topic", selectedTopic);
			
			SessionManager.getInstance().setChosenSession(
					SessionManager.getInstance().createSession(selectedTopic.toString()));
			
			PpsManager.getInstance().setSessionMode(PpsManager.APP_MODE);
			startActivity(i);
			
		}
	};
	
	public Topic getSelectedTopic()
	{
		int index = topicSpinner.getSelectedItemPosition();
		return topics.get(index);
		
	}
	
	OnClickListener goToQuestion = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			join.setEnabled(false);
			
			SessionManager.getInstance().setChosenSession(topicSpin.getSelectedItem().toString());
			
			Intent i = new Intent();
			i.setClass(getBaseContext(), PrivQuestion.class);
			
			PpsManager.getInstance().setSessionMode(PpsManager.APP_MODE);
			startActivity(i);
			
		}

	};
	
	public static void setTopic(String strTopic1){

		strTopic.add(strTopic1);
		adp.notifyDataSetChanged();
	}
	
}
