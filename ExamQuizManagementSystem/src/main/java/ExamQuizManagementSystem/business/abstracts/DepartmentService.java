package ExamQuizManagementSystem.business.abstracts;

import java.util.List;

import ExamQuizManagementSystem.entities.concretes.Department;

public interface DepartmentService {
	void add(Department department);

	void delete(Department department);

	void update(Department department);

	List<Department> getAll();

	Department getByDepartmentId(int departmentId);
}
