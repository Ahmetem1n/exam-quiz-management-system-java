package ExamQuizManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ExamQuizManagementSystem.entities.concretes.Question;

public interface QuestionDao extends JpaRepository<Question, Integer> {
	Question getByQuestionId(int questionId);

	@Query("From Question where exam_id=:examId")
	List<Question> getByExamId(int examId);
}
