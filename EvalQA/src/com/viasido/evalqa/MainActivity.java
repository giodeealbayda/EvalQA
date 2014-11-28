package com.viasido.evalqa;

import java.io.Serializable;
import java.util.ArrayList;

import Objects.Answer;
import Objects.Question;
import Objects.Topic;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private Button teacher;
	private Button student;
	private ArrayList<Topic> topics;
	private Topic math;
	private Topic filipino;
	private Topic english;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		topics = new ArrayList<>();
		
		teacher = (Button) findViewById(R.id.teacher_btn);
		student = (Button) findViewById(R.id.student_btn);

		generateMath();
		generateFilipino();
		generateEnglish();
		
		teacher.setOnClickListener(useTeacher);
		student.setOnClickListener(useStudent);
		
		
		
	}

	public void generateMath()
	{
		math = new Topic("Math");
		ArrayList<Answer> answer1 = new ArrayList<Answer>();
		Question mathQ1 = new Question("1+1");
		Answer mq1A = new Answer("2", true);
		Answer mq1B = new Answer("4", false);
		Answer mq1C = new Answer("5", false);
		Answer mq1D = new Answer("7", false);
		answer1.add(mq1A);
		answer1.add(mq1B);
		answer1.add(mq1C);
		answer1.add(mq1D);
		mathQ1.setAnswers(answer1);
		
		Question mathQ2 = new Question("2+2");
		Answer mq2A = new Answer("2", false);
		Answer mq2B = new Answer("4", true);
		Answer mq2C = new Answer("5", false);
		Answer mq2D = new Answer("7", false);
		ArrayList<Answer> answer2 = new ArrayList<Answer>();
		answer2.add(mq2A);
		answer2.add(mq2B);
		answer2.add(mq2C);
		answer2.add(mq2D);
		mathQ2.setAnswers(answer2);
		
		Question mathQ3 = new Question("2+5");
		Answer mq3A = new Answer("2", false);
		Answer mq3B = new Answer("4", false);
		Answer mq3C = new Answer("5", false);
		Answer mq3D = new Answer("7", true);
		ArrayList<Answer> answer3 = new ArrayList<Answer>();
		answer3.add(mq3A);
		answer3.add(mq3B);
		answer3.add(mq3C);
		answer3.add(mq3D);
		mathQ3.setAnswers(answer3);

		Question mathQ4 = new Question("2+3");
		Answer mq4A = new Answer("2", false);
		Answer mq4B = new Answer("4", false);
		Answer mq4C = new Answer("5", true);
		Answer mq4D = new Answer("7", false);
		ArrayList<Answer> answer4 = new ArrayList<Answer>();
		answer4.add(mq4A);
		answer4.add(mq4B);
		answer4.add(mq4C);
		answer4.add(mq4D);
		mathQ4.setAnswers(answer4);
		
		ArrayList<Question> mathQuestions = new ArrayList<Question>();
		mathQuestions.add(mathQ1);
		mathQuestions.add(mathQ2);
		mathQuestions.add(mathQ3);
		mathQuestions.add(mathQ4);		
		
		math.setQuestions(mathQuestions);	
		this.topics.add(math);
		
	}
	
	public void generateFilipino(){
		filipino = new Topic("Filipino");
		ArrayList<Answer> answer1 = new ArrayList<Answer>();
		Question filQ1 = new Question("Tagalog of dog:");
		Answer filq1A = new Answer("aso", true);
		Answer filq1B = new Answer("pusa", false);
		Answer filq1C = new Answer("daga", false);
		Answer filq1D = new Answer("ibon", false);
		answer1.add(filq1A);
		answer1.add(filq1B);
		answer1.add(filq1C);
		answer1.add(filq1D);
		filQ1.setAnswers(answer1);
		
		Question filQ2 = new Question("Tagalog of cat");
		Answer filq2A = new Answer("aso", false);
		Answer filq2B = new Answer("pusa", true);
		Answer filq2C = new Answer("daga", false);
		Answer filq2D = new Answer("ibon", false);
		ArrayList<Answer> answer2 = new ArrayList<Answer>();
		answer2.add(filq2A);
		answer2.add(filq2B);
		answer2.add(filq2C);
		answer2.add(filq2D);
		filQ2.setAnswers(answer2);
		
		Question filQ3 = new Question("Tagalog of bird");
		Answer filq3A = new Answer("aso", false);
		Answer filq3B = new Answer("pusa", false);
		Answer filq3C = new Answer("daga", false);
		Answer filq3D = new Answer("ibon", true);
		ArrayList<Answer> answer3 = new ArrayList<Answer>();
		answer3.add(filq3A);
		answer3.add(filq3B);
		answer3.add(filq3C);
		answer3.add(filq3D);
		filQ3.setAnswers(answer3);

		Question filQ4 = new Question("Tagalog of rat");
		Answer filq4A = new Answer("aso", false);
		Answer filq4B = new Answer("pusa", false);
		Answer filq4C = new Answer("daga", true);
		Answer filq4D = new Answer("ibon", false);
		ArrayList<Answer> answer4 = new ArrayList<Answer>();
		answer4.add(filq4A);
		answer4.add(filq4B);
		answer4.add(filq4C);
		answer4.add(filq4D);
		filQ4.setAnswers(answer4);
		
		ArrayList<Question> filipinoQuestions = new ArrayList<Question>();
		filipinoQuestions.add(filQ1);
		filipinoQuestions.add(filQ2);
		filipinoQuestions.add(filQ3);
		filipinoQuestions.add(filQ4);
		
		filipino.setQuestions(filipinoQuestions);
		topics.add(filipino);

	}
	
	public void generateEnglish(){
		
		english = new Topic("English");
		ArrayList<Answer> answer1 = new ArrayList<Answer>();
		Question engQ1 = new Question("English of Ate:");
		Answer engq1A = new Answer("Sister", true);
		Answer engq1B = new Answer("Brother", false);
		Answer engq1C = new Answer("Mother", false);
		Answer engq1D = new Answer("Father", false);
		answer1.add(engq1A);
		answer1.add(engq1B);
		answer1.add(engq1C);
		answer1.add(engq1D);
		engQ1.setAnswers(answer1);
		
		Question engQ2 = new Question("English of Kuya");
		ArrayList<Answer> answer2 = new ArrayList<Answer>();
		Answer engq2A = new Answer("Sister", false);
		Answer engq2B = new Answer("Brother", true);
		Answer engq2C = new Answer("Mother", false);
		Answer engq2D = new Answer("Father", false);
		answer2.add(engq2A);
		answer2.add(engq2B);
		answer2.add(engq2C);
		answer2.add(engq2D);
		engQ2.setAnswers(answer2);
		
		Question engQ3 = new Question("English of Nanay");
		ArrayList<Answer> answer3 = new ArrayList<Answer>();
		Answer engq3A = new Answer("Sister", false);
		Answer engq3B = new Answer("Brother", false);
		Answer engq3C = new Answer("Mother", true);
		Answer engq3D = new Answer("Father", false);
		answer3.add(engq3A);
		answer3.add(engq3B);
		answer3.add(engq3C);
		answer3.add(engq3D);
		engQ2.setAnswers(answer3);
		
		Question engQ4 = new Question("English of Kuya");
		ArrayList<Answer> answer4 = new ArrayList<Answer>();
		Answer engq4A = new Answer("Sister", false);
		Answer engq4B = new Answer("Brother", false);
		Answer engq4C = new Answer("Mother", false);
		Answer engq4D = new Answer("Father", true);
		answer4.add(engq4A);
		answer4.add(engq4B);
		answer4.add(engq4C);
		answer4.add(engq4D);
		engQ4.setAnswers(answer4);
		
		ArrayList<Question> englishQuestions = new ArrayList<Question>();
		englishQuestions.add(engQ1);
		englishQuestions.add(engQ2);
		englishQuestions.add(engQ3);
		englishQuestions.add(engQ4);
		
		english.setQuestions(englishQuestions);
		topics.add(english);

		
	}

	
	public ArrayList<Topic> getTopics() {
		return topics;
	}

	public void setTopics(ArrayList<Topic> topics) {
		this.topics = topics;
	}
	
	OnClickListener useTeacher = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i = new Intent();
			i.setClass(getBaseContext(), PubCreateTopic.class);
			System.out.println(math.getTitle());
			i.putExtra("math", math);
			i.putExtra("fil", filipino);
			i.putExtra("eng", english);
			
			startActivity(i);
		}
	};
	
	OnClickListener useStudent = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i = new Intent();
			i.setClass(getBaseContext(), PrivJoin.class);
			startActivity(i);
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
