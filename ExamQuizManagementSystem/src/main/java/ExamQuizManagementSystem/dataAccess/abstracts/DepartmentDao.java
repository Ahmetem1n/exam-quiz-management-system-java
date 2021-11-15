package ExamQuizManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ExamQuizManagementSystem.entities.concretes.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer> {
	Department getByDepartmentId(int departmentId);

}
