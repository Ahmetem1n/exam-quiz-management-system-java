package ExamQuizManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ExamQuizManagementSystem.entities.concretes.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {
	Admin getByAdminId(int adminId);
}
