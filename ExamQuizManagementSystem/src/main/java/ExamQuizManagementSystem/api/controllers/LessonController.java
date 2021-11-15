package ExamQuizManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExamQuizManagementSystem.business.abstracts.LessonService;
import ExamQuizManagementSystem.entities.concretes.Lesson;

@RestController
@RequestMapping("/lesson/")
@CrossOrigin
public class LessonController {
	private LessonService lessonService;

	@Autowired
	public LessonController(LessonService lessonService) {
		super();
		this.lessonService = lessonService;
	}

	@PostMapping("add")
	public void add(Lesson lesson) {
		this.lessonService.add(lesson);
	}

	@PostMapping("delete")
	public void delete(Lesson lesson) {
		this.lessonService.delete(lesson);
	}

	@PostMapping("update")
	public void update(Lesson lesson) {
		this.lessonService.update(lesson);
	}

	@GetMapping("getAll")
	public List<Lesson> getAll() {
		return this.lessonService.getAll();
	}

	@GetMapping("getByLessonId")
	public Lesson getByLessonId(int lessonId) {
		return this.lessonService.getByLessonId(lessonId);
	}
}
