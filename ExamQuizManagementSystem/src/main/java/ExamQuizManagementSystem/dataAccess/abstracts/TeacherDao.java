package ExamQuizManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ExamQuizManagementSystem.entities.concretes.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Integer> {
	Teacher getByTeacherId(int teacherId);

	@Query("From Teacher where user_id=:userId")
	Teacher getByUserId(int userId);
}
