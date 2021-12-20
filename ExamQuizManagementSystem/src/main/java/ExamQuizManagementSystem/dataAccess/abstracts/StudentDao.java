package ExamQuizManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ExamQuizManagementSystem.entities.concretes.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {
	Student getByStudentId(int studentId);

	@Query("From Student where user_id=:userId")
	Student getByUserId(int userId);
}
