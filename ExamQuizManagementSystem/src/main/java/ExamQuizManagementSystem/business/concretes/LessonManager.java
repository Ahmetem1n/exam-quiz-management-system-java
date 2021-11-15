package ExamQuizManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamQuizManagementSystem.business.abstracts.LessonService;
import ExamQuizManagementSystem.dataAccess.abstracts.LessonDao;
import ExamQuizManagementSystem.entities.concretes.Lesson;

@Service
public class LessonManager implements LessonService {
	private LessonDao lessonDao;

	@Autowired
	public LessonManager(LessonDao lessonDao) {
		super();
		this.lessonDao = lessonDao;
	}

	@Override
	public void add(Lesson lesson) {
		if (lessonDao.getByLessonId(lesson.lessonId) == null) {
			this.lessonDao.save(lesson);
			System.out.println("Ekleme işlemi yapıldı.");
		} else {
			System.out.println("Bu id ile zaten kayıt var. Ekleme yapılmadı.");
		}
	}

	@Override
	public void delete(Lesson lesson) {
		if (lessonDao.getByLessonId(lesson.lessonId) != null) {
			this.lessonDao.delete(lesson);
			System.out.println("Silme işlemi yapıldı.");
		} else {
			System.out.println("Böyle bir kayıt bulunamadı. Silme yapılmadı.");
		}
	}

	@Override
	public void update(Lesson lesson) {
		if (lessonDao.getByLessonId(lesson.lessonId) != null) {
			this.lessonDao.save(lesson);
			System.out.println("Güncelleme işlemi yapıldı.");
		} else {
			System.out.println("Böyle bir kayıt bulunamadı. Güncelleme yapılmadı.");
		}
	}

	@Override
	public List<Lesson> getAll() {
		if (this.lessonDao.findAll().size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
		}
		return this.lessonDao.findAll();
	}

	@Override
	public Lesson getByLessonId(int lessonId) {
		if (this.lessonDao.getByLessonId(lessonId) == null) {
			System.out.println("Bu id ile kayıt bulunamadı.");
		}
		return this.lessonDao.getByLessonId(lessonId);
	}

}
