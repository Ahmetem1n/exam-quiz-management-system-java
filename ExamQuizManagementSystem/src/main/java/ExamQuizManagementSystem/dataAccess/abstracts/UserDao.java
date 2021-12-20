package ExamQuizManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ExamQuizManagementSystem.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User getByUserId(int userId);

	@Query("From User where user_nationality_id=:nationalityId and user_password=:userPassword")
	User loginUser(String nationalityId, String userPassword);

}
