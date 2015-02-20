package com.viasido.evalqa;

import java.util.ArrayList;

import Objects.Answer;
import Objects.Question;
import Objects.StudentAnswer;
import Objects.Topic;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.llsx.pps.PpsManager;
import com.llsx.pps.event.Event;
import com.llsx.pps.event.EventManager;
import com.llsx.pps.session.SessionManager;

public class PrivQuestion extends Activity {
	
	private static TextView txttopic;
	private static TextView question;
	
	private static Button option_a;
	private static Button option_b;
	private static Button option_c;
	private static Button option_d;
	
	private static int question_ctr = 0;
	private int student_ctr = 0;
	
	private ArrayList<Question> questionList = new ArrayList<Question>();;
	private ArrayList<StudentAnswer> studentAnswer = new ArrayList<StudentAnswer>();
	private static ArrayList<Answer> choices;
	
	static Activity activity;
	static Topic topicObject;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_priv_question);
		activity = this;
		txttopic = (TextView) findViewById(R.id.tv_topic);
		question = (TextView) findViewById(R.id.tv_privQNum);
		
		option_a = (Button) findViewById(R.id.btn_privA1);
		option_b = (Button) findViewById(R.id.btn_privA2);
		option_c = (Button) findViewById(R.id.btn_privA3);
		option_d = (Button) findViewById(R.id.btn_privA4);
		
		option_a.setOnClickListener(select1);
		option_b.setOnClickListener(select2);
		option_c.setOnClickListener(select3);
		option_d.setOnClickListener(select4);
		
		EventManager.getInstance().setEventHandler(new QAEventHandler());	
	}

	@Override
	protected void onPause(){
		super.onPause();
		PpsManager.getInstance().stop();
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		PpsManager.getInstance().start();
	}
	
	private void disableAll(){
		option_a.setEnabled(false);
		option_b.setEnabled(false);
		option_c.setEnabled(false);
		option_d.setEnabled(false);
	}
	
	public static void enableAll(){
		option_a.setEnabled(true);
		option_b.setEnabled(true);
		option_c.setEnabled(true);
		option_d.setEnabled(true);
	}
	OnClickListener select1 = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Event event = new Event(Event.R_PUBLIC_SCREENS, QAEvent.SEND_ANS, "a-"+SessionManager.getInstance().getOwnDeviceName());

			disableAll();
			EventManager.getInstance().sendEvent(event);							
		}

	};
	
	
	OnClickListener select2 = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub	
			//SessionManager.getInstance().setChosenSession(topicSpin.getSelectedItem().toString());
			
			Event event = new Event(Event.R_PUBLIC_SCREENS, QAEvent.SEND_ANS, "b-"+SessionManager.getInstance().getOwnDeviceName());

			disableAll();
			EventManager.getInstance().sendEvent(event);
		}

	};
	
	OnClickListener select3 = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Event event = new Event(Event.R_PUBLIC_SCREENS, QAEvent.SEND_ANS, "c-"+SessionManager.getInstance().getOwnDeviceName());

			disableAll();
			EventManager.getInstance().sendEvent(event);
		}

	};
	
	OnClickListener select4 = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Event event = new Event(Event.R_PUBLIC_SCREENS, QAEvent.SEND_ANS, "d-"+SessionManager.getInstance().getOwnDeviceName());

			disableAll();
			EventManager.getInstance().sendEvent(event);	
		}

	};
	public static void receiveTopic(Topic topic) {
		Toast.makeText(activity, "The title of topic is: " + topic.getTitle(), Toast.LENGTH_LONG).show();
		topicObject = topic;
		
		txttopic.setText(topic.getTitle());
		question.setText(topic.getQuestions().get(question_ctr).getQuestion());
		
		choices = topic.getQuestions().get(question_ctr).getAnswers();
		option_a.setText(choices.get(0).toString());
		option_b.setText(choices.get(1).toString());
		option_c.setText(choices.get(2).toString());
		option_d.setText(choices.get(3).toString());
	}
	
	public static void nextQuestion(Question q){
		
		enableAll();
		
		question.setText(q.getQuestion());
		ArrayList<Answer> a = q.getAnswers();
		
		option_a.setText(a.get(0).toString());
		option_b.setText(a.get(1).toString());
		option_c.setText(a.get(2).toString());
		option_d.setText(a.get(3).toString());
	}
	
	
	
	
}
