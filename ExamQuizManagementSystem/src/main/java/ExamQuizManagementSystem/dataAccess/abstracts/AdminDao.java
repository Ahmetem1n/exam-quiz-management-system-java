package ExamQuizManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ExamQuizManagementSystem.entities.concretes.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {
	Admin getByAdminId(int adminId);
	
	@Query("From Admin where user_id=:userId")
	Admin getByUserId(int userId);
}
