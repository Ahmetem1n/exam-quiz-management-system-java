package ExamQuizManagementSystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExamQuizManagementSystem.business.abstracts.ExamResultService;
import ExamQuizManagementSystem.entities.concretes.ExamResult;

@RestController
@CrossOrigin
@RequestMapping("/examResult/")
public class ExamResultManager {
	private ExamResultService examResultService;

	@Autowired
	public ExamResultManager(ExamResultService examResultService) {
		super();
		this.examResultService = examResultService;
	}

	@PostMapping("add")
	public void add(ExamResult examResult) {
		this.examResultService.add(examResult);
	}
}
