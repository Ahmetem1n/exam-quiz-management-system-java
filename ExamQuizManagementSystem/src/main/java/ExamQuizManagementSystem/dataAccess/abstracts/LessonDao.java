package ExamQuizManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ExamQuizManagementSystem.entities.concretes.Lesson;

public interface LessonDao extends JpaRepository<Lesson, Integer> {
	Lesson getByLessonId(int lessonId);

}
