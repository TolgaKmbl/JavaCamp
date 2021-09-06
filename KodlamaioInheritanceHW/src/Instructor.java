
public class Instructor extends User {
	private String instructorNumber;
	private String[] coursesGiven;
	
	public Instructor(String[] coursesGiven) {
		this.coursesGiven = coursesGiven;
	}

	public String getInstructorNumber() {
		return instructorNumber;
	}

	public void setInstructorNumber(String instructorNumber) {
		this.instructorNumber = instructorNumber;
	}

	public String[] getCoursesGiven() {
		return coursesGiven;
	}

	public void setCoursesGiven(String[] coursesGiven) {
		this.coursesGiven = coursesGiven;
	}
	
	
}
