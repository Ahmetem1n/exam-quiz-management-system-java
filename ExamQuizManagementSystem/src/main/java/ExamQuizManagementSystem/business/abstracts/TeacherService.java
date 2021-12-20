package ExamQuizManagementSystem.business.abstracts;

import java.util.List;

import ExamQuizManagementSystem.entities.concretes.Teacher;

public interface TeacherService {
	void add(Teacher teacher);

	void delete(Teacher teacher);

	void update(Teacher teacher);

	List<Teacher> getAll();

	Teacher getByTeacherId(int teacherId);
	
	Teacher getByUserId(int userId);
}
