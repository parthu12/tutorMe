/**
 *
 * @author Peggy
 */

public class Signup {

	public Student createStudent(String name, String email, String password) {
		if (name == null || name.trim().length() == 0) {
			throw new IllegalArgumentException("Name cannot be empty!");
		}
		if (email == null || email.trim().length() == 0) {
			throw new IllegalArgumentException("Email cannot be empty!");
		}
		if (password == null || password.trim().length() == 0) {
			throw new IllegalArgumentException("Password cannot be empty!");
		}
		if (email == null || email.trim().length() == 0) {
			throw new IllegalArgumentException("Person email cannot be empty!");
		}
		if (password == null || password.trim().length() == 0) {
			throw new IllegalArgumentException("Person password cannot be empty!");
		}
		if (email == null || email.trim().length() == 0) {
			throw new IllegalArgumentException("Person email cannot be empty!");
		}
		if (password == null || password.trim().length() == 0) {
			throw new IllegalArgumentException("Person password cannot be empty!");
		}
		Student student = new Student();
		student.setFullName(name);
		student.setEmail(email);
		student.setPassword(password);
		studentRepository.save(student);
		return student;
	}