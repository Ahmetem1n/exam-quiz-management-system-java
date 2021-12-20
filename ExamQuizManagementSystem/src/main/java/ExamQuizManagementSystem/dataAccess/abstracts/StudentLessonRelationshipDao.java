package ExamQuizManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ExamQuizManagementSystem.entities.concretes.StudentLessonRelationship;

public interface StudentLessonRelationshipDao extends JpaRepository<StudentLessonRelationship, Integer> {
	StudentLessonRelationship getByRelationshipId(int relationshipId);
}
