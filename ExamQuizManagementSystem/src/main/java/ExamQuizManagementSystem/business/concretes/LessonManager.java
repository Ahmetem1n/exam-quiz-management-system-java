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
		if (lessonDao.getByLessonId(lesson.getLessonId()) == null) {
			this.lessonDao.save(lesson);
			System.out.println("Ekleme işlemi yapıldı.");
			return;
		}
		System.out.println("Bu id ile zaten kayıt var. Ekleme yapılmadı.");

	}

	@Override
	public void delete(Lesson lesson) {
		if (lessonDao.getByLessonId(lesson.getLessonId()) != null) {
			this.lessonDao.delete(lesson);
			System.out.println("Silme işlemi yapıldı.");
		}
		System.out.println("Böyle bir kayıt bulunamadı. Silme yapılmadı.");

	}

	@Override
	public void update(Lesson lesson) {
		if (lessonDao.getByLessonId(lesson.getLessonId()) != null) {
			this.lessonDao.save(lesson);
			System.out.println("Güncelleme işlemi yapıldı.");
		}
		System.out.println("Böyle bir kayıt bulunamadı. Güncelleme yapılmadı.");

	}

	@Override
	public List<Lesson> getAll() {
		if (this.lessonDao.findAll().size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
			return null;
		}
		return this.lessonDao.findAll();
	}

	@Override
	public Lesson getByLessonId(int lessonId) {
		if (this.lessonDao.getByLessonId(lessonId) == null) {
			System.out.println("Bu id ile kayıt bulunamadı.");
			return null;
		}
		return this.lessonDao.getByLessonId(lessonId);
	}

	@Override
	public List<Lesson> getByTeacherId(int teacherId) {
		if (this.lessonDao.getByTeacherId(teacherId).size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
			return null;
		}
		return this.lessonDao.getByTeacherId(teacherId);
	}

	@Override
	public List<Lesson> getByStudentId(int studentId) {
		if (this.lessonDao.getByStudentId(studentId).size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
			return null;
		}
		return this.lessonDao.getByStudentId(studentId);
	}

}
