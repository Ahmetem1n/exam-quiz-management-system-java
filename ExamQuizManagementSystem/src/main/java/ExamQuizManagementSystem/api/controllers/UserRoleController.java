package ExamQuizManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExamQuizManagementSystem.business.abstracts.UserRoleService;
import ExamQuizManagementSystem.entities.concretes.UserRole;

@RestController
@RequestMapping("/userRole/")
@CrossOrigin
public class UserRoleController {
	private UserRoleService userRoleService;

	@Autowired
	public UserRoleController(UserRoleService userRoleService) {
		super();
		this.userRoleService = userRoleService;
	}

	@PostMapping("add")
	public void add( UserRole userRole) {
		this.userRoleService.add(userRole);
	}

	@PostMapping("delete")
	public void delete( UserRole userRole) {
		this.userRoleService.delete(userRole);
	}

	@PostMapping("update")
	public void update( UserRole userRole) {
		this.userRoleService.update(userRole);
	}

	@GetMapping("getAll")
	public List<UserRole> getAll() {
		return this.userRoleService.getAll();
	}

	@GetMapping("getByRoleId")
	public UserRole getByRoleId(int roleId) {
		return this.userRoleService.getByRoleId(roleId);
	}
}
