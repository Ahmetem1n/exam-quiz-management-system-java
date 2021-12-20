package ExamQuizManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ExamQuizManagementSystem.entities.concretes.Exam;

public interface ExamDao extends JpaRepository<Exam, Integer> {
	Exam getByExamId(int examId);

	@Query("From Exam where lesson_id=:lessonId")
	List<Exam> getByLessonId(int lessonId);

	@Query("From Exam where lesson_id=:lessonId and active=true")
	List<Exam> getByActive(int lessonId);

	@Query(value = "select e.exam_id,e.lesson_id,e.active from exams e inner join student_lesson_relationship s on s.lesson_id=e.lesson_id where student_id=:studentId", nativeQuery = true)
	List<Exam> getAllByStudent(int studentId);

	@Query(value = "select e.exam_id,e.lesson_id,e.active from exams e inner join lessons l on l.lesson_id=e.lesson_id where teacher_id=:teacherId", nativeQuery = true)
	List<Exam> getAllByTeacher(int teacherId);
}
