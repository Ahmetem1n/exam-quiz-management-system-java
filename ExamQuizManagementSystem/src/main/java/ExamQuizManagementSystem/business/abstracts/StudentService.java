package ExamQuizManagementSystem.business.abstracts;

import java.util.List;

import ExamQuizManagementSystem.entities.concretes.Student;

public interface StudentService {
	void add(Student student);

	void delete(Student student);

	void update(Student student);

	List<Student> getAll();

	Student getByStudentId(int studentId);

	Student getByUserId(int userId);
}
