package ExamQuizManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExamQuizManagementSystem.business.abstracts.TeacherService;
import ExamQuizManagementSystem.entities.concretes.Teacher;

@RestController
@RequestMapping("/teacher/")
@CrossOrigin
public class TeacherController {
	private TeacherService teacherService;

	@Autowired
	public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}

	@PostMapping("add")
	public void add(Teacher teacher) {
		this.teacherService.add(teacher);
	}

	@PostMapping("delete")
	public void delete(Teacher teacher) {
		this.teacherService.delete(teacher);
	}

	@PostMapping("update")
	public void update(Teacher teacher) {
		this.teacherService.update(teacher);
	}

	@GetMapping("getAll")
	public List<Teacher> getAll() {
		return this.teacherService.getAll();
	}

	@GetMapping("getByTeacherId")
	public Teacher getByTeacherId(int teacherId) {
		return this.teacherService.getByTeacherId(teacherId);
	}

	@GetMapping("getByUserId")
	public Teacher getByUserId(int userId) {
		return this.teacherService.getByUserId(userId);
	}

}
