package com.example.evalqa;

import Objects.Topic;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PubStudentList extends Activity {

	private Button startquiz;
	private TextView topicTitle;
	private Topic topic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pub_student_list);
		
		startquiz = (Button) findViewById(R.id.startquiz_btn);
		startquiz.setOnClickListener(startQuiz);
		topic = (Topic) getIntent().getSerializableExtra("topic");
		
		
		topicTitle = (TextView) findViewById(R.id.topicTitle);
		topicTitle.setText((CharSequence) getIntent().getSerializableExtra("topic").toString());
		
	}

	OnClickListener startQuiz = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i = new Intent();
			i.setClass(getBaseContext(), PubQuestion.class);
			i.putExtra("topic", topic);
			startActivity(i);
		}
	};
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pub_student_list, menu);
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
