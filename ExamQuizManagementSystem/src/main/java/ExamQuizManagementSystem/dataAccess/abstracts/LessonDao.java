package ExamQuizManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ExamQuizManagementSystem.entities.concretes.Lesson;

public interface LessonDao extends JpaRepository<Lesson, Integer> {
	Lesson getByLessonId(int lessonId);

	@Query("From Lesson where teacher_id=:teacherId")
	List<Lesson> getByTeacherId(int teacherId);

	@Query(value = "l.lesson_id,l.teacher_id,l.department_id,l.lesson_name,l.lesson_teams_code,l.lesson_material_link from lessons l inner join student_lesson_relationship s on l.lesson_id=s.lesson_id where student_id=:studentId", nativeQuery = true)
	List<Lesson> getByStudentId(int studentId);
}
