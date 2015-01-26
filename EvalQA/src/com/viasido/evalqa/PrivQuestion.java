package com.viasido.evalqa;

import java.util.ArrayList;

import Objects.Answer;
import Objects.Question;
import Objects.StudentAnswer;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class PrivQuestion extends Activity {
	
	private TextView topic;
	private TextView question;
	
	private Button option_a;
	private Button option_b;
	private Button option_c;
	private Button option_d;
	
	private int question_ctr = 0;
	private int student_ctr = 0;
	
	private ArrayList<Question> questionList = PrivJoin.t.getQuestions();
	private ArrayList<StudentAnswer> studentAnswer = new ArrayList<StudentAnswer>();
	private ArrayList<Answer> choices;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_priv_question);
		
		topic = (TextView) findViewById(R.id.tv_topic);
		question = (TextView) findViewById(R.id.tv_privQNum);
		
		option_a = (Button) findViewById(R.id.btn_privA1);
		option_b = (Button) findViewById(R.id.btn_privA2);
		option_c = (Button) findViewById(R.id.btn_privA3);
		option_d = (Button) findViewById(R.id.btn_privA4);
		
		topic.setText(PrivJoin.t.getTitle());
		question.setText(questionList.get(question_ctr).getQuestion());
		
		choices = questionList.get(question_ctr).getAnswers();
		option_a.setText(choices.get(0).toString());
		option_b.setText(choices.get(1).toString());
		option_c.setText(choices.get(2).toString());
		option_d.setText(choices.get(3).toString());
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.priv_question, menu);
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
