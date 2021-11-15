package ExamQuizManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ExamQuizManagementSystem.entities.concretes.UserRole;

public interface UserRoleDao extends JpaRepository<UserRole, Integer> {
	UserRole getByRoleId(int roleId);
}
