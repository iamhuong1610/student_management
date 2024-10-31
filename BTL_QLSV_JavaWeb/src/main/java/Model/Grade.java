package Model;

public class Grade {
	private int grade_ID; 
	private int class_ID;
	private int student_ID; 
	private int course_ID;
	private float tx1;
	private float tx2;
	private float exam_Score;
	private String letter_Score;
	
	public Grade()
	{
		
	}
	
	
	
	public Grade(int class_ID, int student_ID, int course_ID, float tx1, float tx2, float exam_Score,
			String letter_Score) {
		super();
		this.class_ID = class_ID;
		this.student_ID = student_ID;
		this.course_ID = course_ID;
		this.tx1 = tx1;
		this.tx2 = tx2;
		this.exam_Score = exam_Score;
		this.letter_Score = letter_Score;
	}



	public Grade(int grade_ID, int class_ID, int student_ID, int course_ID, float tx1, float tx2, float exam_Score,
			String letter_Score) {
		super();
		this.grade_ID = grade_ID;
		this.class_ID = class_ID;
		this.student_ID = student_ID;
		this.course_ID = course_ID;
		this.tx1 = tx1;
		this.tx2 = tx2;
		this.exam_Score = exam_Score;
		this.letter_Score = letter_Score;
	}
	public int getGrade_ID() {
		return grade_ID;
	}
	public void setGrade_ID(int grade_ID) {
		this.grade_ID = grade_ID;
	}
	public int getClass_ID() {
		return class_ID;
	}
	public void setClass_ID(int class_ID) {
		this.class_ID = class_ID;
	}
	public int getStudent_ID() {
		return student_ID;
	}
	public void setStudent_ID(int student_ID) {
		this.student_ID = student_ID;
	}
	public int getCourse_ID() {
		return course_ID;
	}
	public void setCourse_ID(int course_ID) {
		this.course_ID = course_ID;
	}
	public float getTx1() {
		return tx1;
	}
	public void setTx1(float tx1) {
		this.tx1 = tx1;
	}
	public float getTx2() {
		return tx2;
	}
	public void setTx2(float tx2) {
		this.tx2 = tx2;
	}
	public float getExam_Score() {
		return exam_Score;
	}
	public void setExam_Score(float exam_Score) {
		this.exam_Score = exam_Score;
	}
	public String getLetter_Score() {
		return letter_Score;
	}
	public void setLetter_Score(String letter_Score) {
		this.letter_Score = letter_Score;
	}



	@Override
	public String toString() {
		return "Grade [grade_ID=" + grade_ID + ", class_ID=" + class_ID + ", student_ID=" + student_ID + ", course_ID="
				+ course_ID + ", tx1=" + tx1 + ", tx2=" + tx2 + ", exam_Score=" + exam_Score + ", letter_Score="
				+ letter_Score + "]";
	}
	
	
}
