package ExamQuizManagementSystem.business.abstracts;

import java.util.List;

import ExamQuizManagementSystem.entities.concretes.Exam;

public interface ExamService {
	void add(Exam exam);

	void delete(Exam exam);

	void update(Exam exam);

	List<Exam> getAll();

	Exam getByExamId(int examId);
}
