package ExamQuizManagementSystem.business.abstracts;

import java.util.List;

import ExamQuizManagementSystem.entities.concretes.Faculty;

public interface FacultyService {
	void add(Faculty faculty);

	void delete(Faculty faculty);

	void update(Faculty faculty);

	List<Faculty> getAll();

	Faculty getByFacultyId(int facultyId);
}
