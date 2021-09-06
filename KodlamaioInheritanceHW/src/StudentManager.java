
public class StudentManager extends UserManager {
	public void join(Student student) {
		System.out.println(student.getStudentNumber() + " numaralı öğrenci " +  student.getFirstName());
		for (String course : student.getCoursesTaken()) {
			System.out.print(course + ", ");
		}
		System.out.println(" isimli kurslara katıldı.");
	}
}
