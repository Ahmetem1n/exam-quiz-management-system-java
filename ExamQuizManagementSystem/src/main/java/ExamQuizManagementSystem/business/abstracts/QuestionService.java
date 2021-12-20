package ExamQuizManagementSystem.business.abstracts;

import java.util.List;

import ExamQuizManagementSystem.entities.concretes.Question;

public interface QuestionService {
	void add(Question question);

	void delete(Question question);

	void update(Question question);

	List<Question> getAll();

	Question getByQuestionId(int questionId);

	List<Question> getByExamId(int examId);
}
