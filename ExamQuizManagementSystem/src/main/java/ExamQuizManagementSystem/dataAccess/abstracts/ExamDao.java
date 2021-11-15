package ExamQuizManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ExamQuizManagementSystem.entities.concretes.Exam;

public interface ExamDao extends JpaRepository<Exam, Integer> {
	Exam getByExamId(int examID);
}
