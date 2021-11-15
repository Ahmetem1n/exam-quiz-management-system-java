package ExamQuizManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ExamQuizManagementSystem.entities.concretes.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {
	Student getByStudentId(int studentId);

}
