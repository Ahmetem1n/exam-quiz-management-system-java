package ExamQuizManagementSystem.business.abstracts;

import java.util.List;

import ExamQuizManagementSystem.entities.concretes.ExamResult;

public interface ExamResultService {
	void add(ExamResult examResult);
	
	void create(ExamResult examResult);

	void delete(ExamResult examResult);

	void update(ExamResult examResult);

	List<ExamResult> getAll();

	ExamResult getByResultId(int resultId);

	List<ExamResult> getByStudentId(int studentId);

	ExamResult getByExamIdAndStudentId(int examId, int studentId);
}
