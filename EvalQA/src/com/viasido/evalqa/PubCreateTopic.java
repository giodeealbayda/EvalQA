package com.viasido.evalqa;

import java.util.ArrayList;

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

public class PubCreateTopic extends Activity {
	
	private Button startBtn;
	private Spinner topicSpinner;
	private ArrayList<Topic> topics;
	private Topic selectedTopic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pub_create_topic);
		
		topics = new ArrayList<Topic>();
		selectedTopic = new Topic(null);
		ArrayList<String> topiclist = new ArrayList<String>();
		startBtn = (Button) findViewById(R.id.start_btn);
		startBtn.setOnClickListener(goToStudentList);
		topicSpinner = (Spinner) findViewById(R.id.pub_topic);
		Topic math = (Topic) getIntent().getSerializableExtra("math");
		System.out.println(math.getTitle());
		Topic fil = (Topic) getIntent().getSerializableExtra("fil");
		Topic eng = (Topic) getIntent().getSerializableExtra("eng");
		topics.add(math);
		topics.add(fil);
		topics.add(eng);
		
		for(int i = 0; i < topics.size(); i++)
		{
			topiclist.add(topics.get(i).toString());
		}
		ArrayAdapter adapter = new ArrayAdapter(getBaseContext(), R.layout.list_item, topiclist);
		topicSpinner.setAdapter(adapter);
		
	}

	OnClickListener goToStudentList = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i = new Intent();
			i.setClass(getBaseContext(), PubStudentList.class);
			selectedTopic = getSelectedTopic();
			i.putExtra("topic", selectedTopic);
			startActivity(i);
			
		}
	};
	
	public Topic getSelectedTopic()
	{
		int index = topicSpinner.getSelectedItemPosition();
		return topics.get(index);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pub_create_topic, menu);
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
