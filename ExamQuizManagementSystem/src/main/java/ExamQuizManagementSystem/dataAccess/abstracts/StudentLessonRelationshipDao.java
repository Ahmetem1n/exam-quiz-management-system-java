package ExamQuizManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ExamQuizManagementSystem.entities.concretes.StudentLessonRelationship;

public interface StudentLessonRelationshipDao extends JpaRepository<StudentLessonRelationship, Integer> {
	StudentLessonRelationship getByRelationshipId(int relationshipId);

	@Query("From StudentLessonRelationship where student_id=:studentId")
	List<StudentLessonRelationship> getByStudentId(int studentId);

	@Query("From StudentLessonRelationship where lesson_id=:lessonId")
	List<StudentLessonRelationship> getByLessonId(int lessonId);

	@Query(value = "select s.relationship_id,s.lesson_id,s.student_id from student_lesson_relationship s inner join lessons l on s.lesson_id=l.lesson_id where teacher_id=:teacherId", nativeQuery = true)
	List<StudentLessonRelationship> getByTeacher(int teacherId);
}
