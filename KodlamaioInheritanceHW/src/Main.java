
public class Main {

	public static void main(String[] args) {
		Instructor instructor = new Instructor(new String[] {"Java","React","C#"});
		instructor.setId(1);
		instructor.setFirstName("Engin");
		instructor.setLastName("Demiro�");
		instructor.setInstructorNumber("12346789");

		Student student = new Student(new String[] {"Java","Solidity","React"});
		student.setId(1);
		student.setFirstName("Tolga");
		student.setLastName("K�mb�l");
		student.setStudentNumber("987654321");

		Course course = new Course(1, "Java", "Engin Demiro�");
		
		CourseManager courseManager = new CourseManager();
		courseManager.add(course);
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.open(instructor);
		StudentManager studentManager = new StudentManager();
		studentManager.join(student);
		studentManager.addUser(student);

	}

}
