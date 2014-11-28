package Objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Topic implements Serializable {
	
	private String title;
	private ArrayList<Question> questions;
	
	public Topic(String title)
	{
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return title;
	}
	
	

}
