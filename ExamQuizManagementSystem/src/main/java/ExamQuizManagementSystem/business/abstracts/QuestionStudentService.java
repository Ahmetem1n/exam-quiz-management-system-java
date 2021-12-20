package ExamQuizManagementSystem.business.abstracts;

import java.util.List;

import ExamQuizManagementSystem.entities.concretes.QuestionStudent;

public interface QuestionStudentService {
	void add(QuestionStudent questionStudent);

	void delete(QuestionStudent questionStudent);

	void update(QuestionStudent questionStudent);

	List<QuestionStudent> getAll();

	QuestionStudent getByDetailId(int detailId);

}
