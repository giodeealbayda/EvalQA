package Objects;

import java.util.ArrayList;

public class StudentAnswer {
	private int studentScore;
	private String studentName;
	
	public void setStudentName(String name){
		this.studentName = name;
	}
	
	public void setStudentScore(int studentScore){
		this.studentScore = studentScore;
	}
	
	public String getStudentName(){
		return studentName;
	}
	
	public int getStudentScore(){
		return studentScore;
	}

}
