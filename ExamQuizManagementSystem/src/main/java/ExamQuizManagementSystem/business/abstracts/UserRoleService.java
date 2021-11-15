package ExamQuizManagementSystem.business.abstracts;

import java.util.List;

import ExamQuizManagementSystem.entities.concretes.UserRole;

public interface UserRoleService {
	void add(UserRole userRole);

	void delete(UserRole userRole);

	void update(UserRole userRole);

	List<UserRole> getAll();

	UserRole getByRoleId(int roleId);
}
