package ExamQuizManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExamQuizManagementSystem.business.abstracts.UserService;
import ExamQuizManagementSystem.entities.concretes.User;

@RestController
@RequestMapping("/user/")
@CrossOrigin
public class UserController {
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("add")
	public void add(User user) {
		this.userService.add(user);
	}

	@PostMapping("delete")
	public void delete(User user) {
		this.userService.delete(user);
	}

	@PostMapping("update")
	public void update(User user) {
		this.userService.update(user);
	}

	@GetMapping("getAll")
	public List<User> getAll() {
		return this.userService.getAll();
	}

	@GetMapping("getByUserId")
	public User getByUserId(int userId) {
		return this.userService.getByUserId(userId);
	}

	@GetMapping("login")
	public User login(String nationalityId, String password) {
		return this.userService.login(nationalityId, password);
	}
}
