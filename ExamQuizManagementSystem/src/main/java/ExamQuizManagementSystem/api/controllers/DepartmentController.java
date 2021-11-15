package ExamQuizManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExamQuizManagementSystem.business.abstracts.DepartmentService;
import ExamQuizManagementSystem.entities.concretes.Department;

@RestController
@RequestMapping("/department/")
@CrossOrigin
public class DepartmentController {
	private DepartmentService departmentService;

	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}

	@PostMapping("add")
	public void add(Department department) {
		this.departmentService.add(department);
	}

	@PostMapping("delete")
	public void delete(Department department) {
		this.departmentService.delete(department);
	}

	@PostMapping("update")
	public void update(Department department) {
		this.departmentService.update(department);
	}

	@GetMapping("getAll")
	public List<Department> getAll() {
		return this.departmentService.getAll();
	}

	@GetMapping("getByDepartmentId")
	public Department getByDepartmentId(int departmentId) {
		return this.departmentService.getByDepartmentId(departmentId);
	}

}
