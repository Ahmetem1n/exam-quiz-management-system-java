package ExamQuizManagementSystem.business.abstracts;

import java.util.List;

import ExamQuizManagementSystem.entities.concretes.StudentLessonRelationship;

public interface StudentLessonRelationshipService {
	void add(StudentLessonRelationship relationship);

	void delete(StudentLessonRelationship relationship);

	void update(StudentLessonRelationship relationship);

	List<StudentLessonRelationship> getAll();

	StudentLessonRelationship getByRelationshipId(int relationshipId);
	
	List<StudentLessonRelationship> getByStudentId(int studentId);
	
	List<StudentLessonRelationship> getByLessonId(int lessonId);
	
	List<StudentLessonRelationship> getByTeacher(int teacherId);
}

