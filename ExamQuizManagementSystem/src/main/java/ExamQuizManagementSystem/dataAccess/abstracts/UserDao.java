package ExamQuizManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ExamQuizManagementSystem.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User getByUserId(int userId);
}
