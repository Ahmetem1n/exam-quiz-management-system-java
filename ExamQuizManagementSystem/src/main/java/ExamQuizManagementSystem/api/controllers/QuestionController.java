package ExamQuizManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExamQuizManagementSystem.business.abstracts.QuestionService;
import ExamQuizManagementSystem.entities.concretes.Question;

@RestController
@RequestMapping("/question/")
@CrossOrigin
public class QuestionController {
	private QuestionService questionService;

	@Autowired
	public QuestionController(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}

	@PostMapping("add")
	public void add(Question question) {
		this.questionService.add(question);
	}

	@PostMapping("delete")
	public void delete(Question question) {
		this.questionService.delete(question);
	}

	@PostMapping("update")
	public void update(Question question) {
		this.questionService.update(question);
	}

	@GetMapping("getAll")
	public List<Question> getAll() {
		return this.questionService.getAll();
	}

	@GetMapping("getByQuestionId")
	public Question getByQuestionId(int questionId) {
		return this.questionService.getByQuestionId(questionId);
	}

	@GetMapping("getByExamId")
	public List<Question> getByExamId(int examId) {
		return this.questionService.getByExamId(examId);
	}
}
