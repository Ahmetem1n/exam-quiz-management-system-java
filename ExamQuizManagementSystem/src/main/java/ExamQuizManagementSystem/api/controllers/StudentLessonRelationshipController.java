package ExamQuizManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExamQuizManagementSystem.business.abstracts.StudentLessonRelationshipService;
import ExamQuizManagementSystem.entities.concretes.StudentLessonRelationship;

@RestController
@RequestMapping("/studentLessonRelationship/")
@CrossOrigin
public class StudentLessonRelationshipController {
	StudentLessonRelationshipService relationshipService;

	@Autowired
	public StudentLessonRelationshipController(StudentLessonRelationshipService relationshipService) {
		super();
		this.relationshipService = relationshipService;
	}

	@PostMapping("add")
	public void add(StudentLessonRelationship relationship) {
		this.relationshipService.add(relationship);
	}

	@PostMapping("delete")
	public void delete(StudentLessonRelationship relationship) {
		this.relationshipService.delete(relationship);
	}

	@PostMapping("update")
	public void update(StudentLessonRelationship relationship) {
		this.relationshipService.update(relationship);
	}

	@GetMapping("getAll")
	public List<StudentLessonRelationship> getAll() {
		return this.relationshipService.getAll();
	}

	@GetMapping("getByRelationshipId")
	public StudentLessonRelationship getByRelationshipId(int relationshipId) {
		return this.relationshipService.getByRelationshipId(relationshipId);
	}

	@GetMapping("getByStudentId")
	public List<StudentLessonRelationship> getByStudentId(int studentId) {
		return this.relationshipService.getByStudentId(studentId);
	}

	@GetMapping("getByTeacher")
	public List<StudentLessonRelationship> getByTeacher(int teacherId) {
		return this.relationshipService.getByTeacher(teacherId);
	}

}
