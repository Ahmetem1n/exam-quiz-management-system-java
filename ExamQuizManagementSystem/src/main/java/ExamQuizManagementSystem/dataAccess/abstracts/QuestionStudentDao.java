package ExamQuizManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ExamQuizManagementSystem.entities.concretes.QuestionStudent;

public interface QuestionStudentDao extends JpaRepository<QuestionStudent, Integer> {
	QuestionStudent getByDetailId(int detailId);
}
