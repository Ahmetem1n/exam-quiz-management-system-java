package ExamQuizManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExamQuizManagementSystem.business.abstracts.QuestionStudentService;
import ExamQuizManagementSystem.entities.concretes.QuestionStudent;

@RestController
@RequestMapping("/questionStudent/")
@CrossOrigin
public class QuestionStudentController {
	private QuestionStudentService questionStudentService;

	@Autowired
	public QuestionStudentController(QuestionStudentService questionStudentService) {
		super();
		this.questionStudentService = questionStudentService;
	}

	@PostMapping("add")
	public void add(QuestionStudent questionStudent) {
		this.questionStudentService.add(questionStudent);
	}

	@PostMapping("delete")
	public void delete(QuestionStudent questionStudent) {
		this.questionStudentService.delete(questionStudent);
	}

	@PostMapping("update")
	public void update(QuestionStudent questionStudent) {
		this.questionStudentService.update(questionStudent);
	}

	@GetMapping("getAll")
	public List<QuestionStudent> getAll() {
		return this.questionStudentService.getAll();
	}

	@GetMapping("getByQuestionId")
	public QuestionStudent getByDetailId(int detailId) {
		return this.questionStudentService.getByDetailId(detailId);
	}
}
