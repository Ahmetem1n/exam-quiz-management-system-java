package ExamQuizManagementSystem.business.abstracts;

import java.util.List;

import ExamQuizManagementSystem.entities.concretes.Admin;

public interface AdminService {
	void add(Admin admin);

	void delete(Admin admin);

	void update(Admin admin);

	List<Admin> getAll();

	Admin getByAdminId(int adminId);
}
