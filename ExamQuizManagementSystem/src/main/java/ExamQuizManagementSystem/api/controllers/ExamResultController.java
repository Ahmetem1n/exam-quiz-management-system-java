package ExamQuizManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExamQuizManagementSystem.business.abstracts.ExamResultService;
import ExamQuizManagementSystem.entities.concretes.ExamResult;

@RestController
@CrossOrigin
@RequestMapping("/examResult/")
public class ExamResultController {

	private ExamResultService examResultService;

	@Autowired
	public ExamResultController(ExamResultService examResultService) {
		super();
		this.examResultService = examResultService;
	}

	@PostMapping("add")
	public void add(ExamResult examResult) {
		this.examResultService.add(examResult);
	}

	@PostMapping("create")
	public void create(ExamResult examResult) {
		this.examResultService.create(examResult);
	}

	@PostMapping("delete")
	public void delete(ExamResult examResult) {
		this.examResultService.delete(examResult);
	}

	@PostMapping("update")
	public void update(ExamResult examResult) {
		this.examResultService.update(examResult);
	}

	@GetMapping("getAll")
	public List<ExamResult> getAll() {
		return this.examResultService.getAll();
	}

	@GetMapping("getByResultId")
	public ExamResult getByResultId(int resultId) {
		return this.examResultService.getByResultId(resultId);
	}

	@GetMapping("getByStudentId")
	public List<ExamResult> getByStudentId(int studentId) {
		return this.examResultService.getByStudentId(studentId);
	}

	@GetMapping("getByExamIdAndStudentId")
	public ExamResult getByExamIdAndStudentId(int examId, int studentId) {
		return this.examResultService.getByExamIdAndStudentId(examId, studentId);
	}

}
