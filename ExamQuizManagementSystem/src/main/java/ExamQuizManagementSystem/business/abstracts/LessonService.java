package ExamQuizManagementSystem.business.abstracts;

import java.util.List;

import ExamQuizManagementSystem.entities.concretes.Lesson;

public interface LessonService {
	void add(Lesson lesson);

	void delete(Lesson lesson);

	void update(Lesson lesson);

	List<Lesson> getAll();

	Lesson getByLessonId(int lessonId);
}
