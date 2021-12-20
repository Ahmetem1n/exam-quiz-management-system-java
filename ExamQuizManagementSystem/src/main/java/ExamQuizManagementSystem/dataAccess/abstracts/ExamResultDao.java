package ExamQuizManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ExamQuizManagementSystem.entities.concretes.ExamResult;

public interface ExamResultDao extends JpaRepository<ExamResult, Integer> {
	ExamResult getByResultId(int resultId);
}
