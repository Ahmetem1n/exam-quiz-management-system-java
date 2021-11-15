package ExamQuizManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExamQuizManagementSystem.business.abstracts.StudentService;
import ExamQuizManagementSystem.entities.concretes.Student;

@RestController
@RequestMapping("/student/")
@CrossOrigin
public class StudentController {
	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@PostMapping("add")
	public void add(Student student) {
		this.studentService.add(student);
	}

	@PostMapping("delete")
	public void delete(Student student) {
		this.studentService.delete(student);
	}

	@PostMapping("update")
	public void update(Student student) {
		this.studentService.update(student);
	}

	@GetMapping("getAll")
	public List<Student> getAll() {
		return this.studentService.getAll();
	}

	@GetMapping("getByStudentId")
	public Student getByStudentId(int studentId) {
		return this.studentService.getByStudentId(studentId);
	}
}
