package ExamQuizManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExamQuizManagementSystem.business.abstracts.FacultyService;
import ExamQuizManagementSystem.entities.concretes.Faculty;

@RestController
@RequestMapping("/faculty/")
@CrossOrigin
public class FacultyController {
	private FacultyService facultyService;

	@Autowired
	public FacultyController(FacultyService facultyService) {
		super();
		this.facultyService = facultyService;
	}

	@PostMapping("add")
	public void add(Faculty faculty) {
		this.facultyService.add(faculty);
	}

	@PostMapping("delete")
	public void delete(Faculty faculty) {
		this.facultyService.delete(faculty);
	}

	@PostMapping("update")
	public void update(Faculty faculty) {
		this.facultyService.update(faculty);
	}

	@GetMapping("getAll")
	public List<Faculty> getAll() {
		return this.facultyService.getAll();
	}

	@GetMapping("getByFacultyId")
	public Faculty getByFacultyId(int facultyId) {
		return this.facultyService.getByFacultyId(facultyId);
	}
}
