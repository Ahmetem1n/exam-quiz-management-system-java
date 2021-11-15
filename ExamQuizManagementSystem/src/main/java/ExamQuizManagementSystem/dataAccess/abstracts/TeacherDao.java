package ExamQuizManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ExamQuizManagementSystem.entities.concretes.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Integer> {
	Teacher getByTeacherId(int teacherId);
}
