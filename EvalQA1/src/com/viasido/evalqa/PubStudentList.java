package com.viasido.evalqa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Objects.Answer;
import Objects.Question;
import Objects.Topic;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.llsx.pps.PpsManager;
import com.llsx.pps.event.Event;
import com.llsx.pps.event.EventManager;

public class PubStudentList extends Activity {

	private Button startquiz;
	private TextView topicTitle;
	private Topic topic;

	private TextView tvTopic;
	private TextView tvQNum;
	private TextView tvQuestion;
	private TextView a1;
	private TextView a2;
	private TextView a3;
	private TextView a4;
	private Button nextBtn;
	private static int questionCtr;
	private static ArrayList<Question> questions;
	
	private static int studentScore;
	
	public static HashMap <String, Integer> studentscoremap = new HashMap<String, Integer>();

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pub_student_list);
		
		startquiz = (Button) findViewById(R.id.startquiz_btn);
		startquiz.setOnClickListener(startQuiz);
		topic = (Topic) getIntent().getSerializableExtra("topic");
		
		topicTitle = (TextView) findViewById(R.id.topicTitle);
		topicTitle.setText((CharSequence) getIntent().getSerializableExtra("topic").toString());
		
		tvTopic = (TextView) findViewById(R.id.tv_topic);
		tvQNum = (TextView) findViewById(R.id.tv_quesNum);
		tvQuestion = (TextView) findViewById(R.id.tv_question);
		a1 = (TextView) findViewById(R.id.tv_a1);
		a2 = (TextView) findViewById(R.id.tv_a2);
		a3 = (TextView) findViewById(R.id.tv_a3);
		a4 = (TextView) findViewById(R.id.tv_a4);
		nextBtn = (Button) findViewById(R.id.nextbtn);
		nextBtn.setEnabled(false);
		questionCtr = 0;
		studentScore=0;
		
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
		
		EventManager.getInstance().setEventHandler(new QAEventHandler());
		
	}

	OnClickListener startQuiz = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			startquiz.setEnabled(false);
			nextBtn.setEnabled(true);
			Event event = new Event(Event.R_PERSONAL_SCREENS, QAEvent.START_QUIZ, topic);
			EventManager.getInstance().sendEvent(event);
		}
	};
	
	OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			questionCtr++;
			if(questionCtr < 4)
			{
				Question question = questions.get(questionCtr);
				
				Event event = new Event(Event.R_PERSONAL_SCREENS, QAEvent.NEXT_QUESTION, question);		
				EventManager.getInstance().sendEvent(event);
				
				tvQuestion.setText(question.getQuestion());
				tvQNum.setText("Question number:"+ (questionCtr + 1));
				ArrayList<Answer> answers = question.getAnswers();
				a1.setText(answers.get(0).toString());
				a2.setText(answers.get(1).toString());
				a3.setText(answers.get(2).toString());
				a4.setText(answers.get(3).toString());
			}
			else
			{
				String message="Score \n";

				
				for(Map.Entry<String, Integer> entry: studentscoremap.entrySet()){
					String key = entry.getKey();
					int value = entry.getValue();
					
					message += key + ": " +value+"\n";
				}
				tvQNum.setText(message);
			}
			
		}
	};
	
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
	
	public static void checkAns(String ans, String name){
		ArrayList<Answer> a = questions.get(questionCtr).getAnswers();
		
		if(!studentscoremap.containsKey(name)){// meron na
			studentscoremap.put(name, 0);
		}
		
		if(ans.equals("a")){
			if(a.get(0).isCorrect()){
				studentscoremap.put(name, studentscoremap.get(name)+1);
				Log.e(name+"-|||"+studentscoremap.get(name), "|||LOG A");
			}
		}else if(ans.equals("b")){
			if(a.get(1).isCorrect()){
				studentscoremap.put(name, studentscoremap.get(name)+1);
				Log.e(name+"-|||"+studentscoremap.get(name), "|||LOG B");
			}
			
		}else if(ans.equals("c")){
			if(a.get(2).isCorrect()){
				studentscoremap.put(name, studentscoremap.get(name)+1);
				Log.e(name+"-|||"+studentscoremap.get(name), "|||LOG C");
			}
		}else if(ans.equals("d")){
			if(a.get(3).isCorrect()){
				studentscoremap.put(name, studentscoremap.get(name)+1);
				Log.e(name+"-|||"+studentscoremap.get(name), "|||LOG D");
			}
		}
		
	}
	
	public int getStudentScore(){
		return studentScore;
	}
}
