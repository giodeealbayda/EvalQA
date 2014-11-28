package com.viasido.evalqa;

import java.util.ArrayList;

import Objects.Answer;
import Objects.Question;
import Objects.Topic;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PubQuestion extends Activity {

	private TextView tvTopic;
	private TextView tvQNum;
	private TextView tvQuestion;
	private TextView a1;
	private TextView a2;
	private TextView a3;
	private TextView a4;
	private Button nextBtn;
	private Topic topic;
	private int questionCtr;
	private ArrayList<Question> questions;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pub_question);
		
		tvTopic = (TextView) findViewById(R.id.tv_topic);
		tvQNum = (TextView) findViewById(R.id.tv_quesNum);
		tvQuestion = (TextView) findViewById(R.id.tv_question);
		a1 = (TextView) findViewById(R.id.tv_a1);
		a2 = (TextView) findViewById(R.id.tv_a2);
		a3 = (TextView) findViewById(R.id.tv_a3);
		a4 = (TextView) findViewById(R.id.tv_a4);
		nextBtn = (Button) findViewById(R.id.nextbtn);
		
		topic = (Topic) getIntent().getSerializableExtra("topic");
		questionCtr = 0;
		System.out.println(topic.getTitle() + " HELLO");
		tvTopic.setText(topic.getTitle());
		tvQNum.setText("Question number:"+ (questionCtr + 1));
	
		
		questions = topic.getQuestions();
		Question question = questions.get(questionCtr);
		tvQuestion.setText(question.getQuestion());
		ArrayList<Answer> answers = question.getAnswers();
		a1.setText(answers.get(0).toString());
		a2.setText(answers.get(1).toString());
		a3.setText(answers.get(2).toString());
		a4.setText(answers.get(3).toString());
		
		nextBtn.setOnClickListener(listener);
		
	}
	
	OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			

			questionCtr++;
			if(questionCtr < 4)
			{
				Question question = questions.get(questionCtr);
				tvQuestion.setText(question.getQuestion());
				ArrayList<Answer> answers = question.getAnswers();
				a1.setText(answers.get(0).toString());
				a2.setText(answers.get(1).toString());
				a3.setText(answers.get(2).toString());
				a4.setText(answers.get(3).toString());
			}
			else
			{
				tvQNum.setText("No more questions");
			}
			
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pub_question, menu);
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
