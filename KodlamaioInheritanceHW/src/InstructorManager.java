
public class InstructorManager extends UserManager {
	public void open(Instructor instructor) {
		System.out.println(instructor.getInstructorNumber() + " numaral� e�itmen " +  instructor.getFirstName());
		for (String course : instructor.getCoursesGiven()) {
			System.out.print(course + ", ");
		}
		System.out.println(" isimli kurslar� vermeye ba�lad�.");
	}
}
