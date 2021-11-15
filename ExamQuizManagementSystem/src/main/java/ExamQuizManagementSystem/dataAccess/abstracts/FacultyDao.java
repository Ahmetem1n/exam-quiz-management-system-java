package ExamQuizManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ExamQuizManagementSystem.entities.concretes.Faculty;

public interface FacultyDao extends JpaRepository<Faculty, Integer> {
	Faculty getByFacultyId(int facultyId);
}
