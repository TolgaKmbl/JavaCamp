
public class Student extends User {
	private String studentNumber;
	private String[] coursesTaken;
	
	public Student(String[] coursesTaken) {
		this.coursesTaken = coursesTaken;
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String[] getCoursesTaken() {
		return coursesTaken;
	}
	public void setCoursesTaken(String[] coursesTaken) {
		this.coursesTaken = coursesTaken;
	}
		
	
}
