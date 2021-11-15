package ExamQuizManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ExamQuizManagementSystem.entities.concretes.Question;

public interface QuestionDao extends JpaRepository<Question, Integer> {
	Question getByQuestionId(int questionId);
}
