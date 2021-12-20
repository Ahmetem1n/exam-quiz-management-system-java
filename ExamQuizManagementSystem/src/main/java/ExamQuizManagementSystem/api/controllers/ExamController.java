package ExamQuizManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExamQuizManagementSystem.business.abstracts.ExamService;
import ExamQuizManagementSystem.entities.concretes.Exam;

@RestController
@RequestMapping("/exam/")
@CrossOrigin
public class ExamController {
	private ExamService examService;

	@Autowired
	public ExamController(ExamService examService) {
		super();
		this.examService = examService;
	}

	@PostMapping("add")
	public void add(Exam exam) {
		this.examService.add(exam);
	}

	@PostMapping("delete")
	public void delete(Exam exam) {
		this.examService.delete(exam);
	}

	@PostMapping("update")
	public void update(Exam exam) {
		this.examService.update(exam);
	}

	@GetMapping("getAll")
	public List<Exam> getAll() {
		return this.examService.getAll();
	}

	@GetMapping("getByExamId")
	public Exam getByExamId(int examId) {
		return this.examService.getByExamId(examId);
	}

	@GetMapping("getAllByTeacher")
	List<Exam> getAllByTeacher(int teacherId) {
		return this.examService.getAllByTeacher(teacherId);
	}

	@GetMapping("getAllByStudent")
	List<Exam> getAllByStudent(int studentId) {
		return this.examService.getAllByStudent(studentId);
	}

	@GetMapping("getByLessonId")
	List<Exam> getByLessonId(int lessonId) {
		return this.examService.getByLessonId(lessonId);
	}

	@GetMapping("getByActive")
	List<Exam> getByActive(int lessonId) {
		return this.examService.getByActive(lessonId);
	}
}
