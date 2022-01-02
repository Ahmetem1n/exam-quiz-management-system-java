package ExamQuizManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ExamQuizManagementSystem.entities.concretes.ExamResult;

public interface ExamResultDao extends JpaRepository<ExamResult, Integer> {
	ExamResult getByResultId(int resultId);

	@Query("From ExamResult where student_id=:studentId")
	List<ExamResult> getByStudentId(int studentId);

	@Query("From ExamResult where exam_id=:examId and student_id=:studentId")
	ExamResult getByExamIdAndStudentId(int examId, int studentId);

	@Query(value = "select count(*) from questions q inner join questions_students qs on qs.question_id=q.question_id where student_id=:studentId and exam_id=:examId and true_option=marked_option", nativeQuery = true)
	int create(int examId, int studentId);
}
