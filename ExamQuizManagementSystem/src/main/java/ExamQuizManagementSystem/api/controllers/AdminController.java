package ExamQuizManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExamQuizManagementSystem.business.abstracts.AdminService;
import ExamQuizManagementSystem.entities.concretes.Admin;

@RestController
@RequestMapping("/admin/")
@CrossOrigin
public class AdminController {
	private AdminService adminService;

	@Autowired
	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}

	@GetMapping("getAll")
	public List<Admin> getAll() {
		return this.adminService.getAll();
	}

	@GetMapping("getByAdminId")
	public Admin getByAdminId(int adminId) {
		return this.adminService.getByAdminId(adminId);
	}

	@GetMapping("getByUserId")
	public Admin getByUserId(int userId) {
		return this.adminService.getByUserId(userId);
	}

	@PostMapping("add")
	public void add(Admin admin) {
		this.adminService.add(admin);
	}

	@PostMapping("delete")
	public void delete(Admin admin) {
		this.adminService.delete(admin);
	}

	@PostMapping("update")
	public void update(Admin admin) {
		this.adminService.update(admin);
	}

}
