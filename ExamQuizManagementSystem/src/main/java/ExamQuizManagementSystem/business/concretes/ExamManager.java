package ExamQuizManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamQuizManagementSystem.business.abstracts.ExamService;
import ExamQuizManagementSystem.dataAccess.abstracts.ExamDao;
import ExamQuizManagementSystem.entities.concretes.Exam;

@Service
public class ExamManager implements ExamService {

	private ExamDao examDao;

	@Autowired
	public ExamManager(ExamDao examDao) {
		super();
		this.examDao = examDao;
	}

	@Override
	public void add(Exam exam) {
		if (examDao.getByExamId(exam.getExamId()) == null) {
			this.examDao.save(exam);
			System.out.println("Ekleme işlemi yapıldı.");
			return;
		}
		System.out.println("Bu id ile zaten kayıt var. Ekleme yapılmadı.");

	}

	@Override
	public void delete(Exam exam) {
		if (examDao.getByExamId(exam.getExamId()) != null) {
			this.examDao.delete(exam);
			System.out.println("Silme işlemi yapıldı.");
			return;

		}
		System.out.println("Böyle bir kayıt bulunamadı. Silme yapılmadı.");

	}

	@Override
	public void update(Exam exam) {
		if (examDao.getByExamId(exam.getExamId()) != null) {
			this.examDao.save(exam);
			System.out.println("Güncelleme işlemi yapıldı.");
			return;
		}
		System.out.println("Böyle bir kayıt bulunamadı. Güncelleme yapılmadı.");

	}

	@Override
	public List<Exam> getAll() {
		if (this.examDao.findAll().size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
			return null;
		}
		return this.examDao.findAll();
	}

	@Override
	public Exam getByExamId(int examId) {
		if (this.examDao.getByExamId(examId) == null) {
			System.out.println("Bu id ile kayıt bulunamadı.");
			return null;
		}
		return this.examDao.getByExamId(examId);
	}

	@Override
	public List<Exam> getAllByTeacher(int teacherId) {

		if (this.examDao.getAllByTeacher(teacherId).size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
			return null;
		}
		return this.examDao.getAllByTeacher(teacherId);
	}

	@Override
	public List<Exam> getAllByStudent(int studentId) {
		if (this.examDao.getAllByStudent(studentId).size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
			return null;
		}
		return this.examDao.getAllByStudent(studentId);
	}

	@Override
	public List<Exam> getByLessonId(int lessonId) {
		if (this.examDao.getByLessonId(lessonId).size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
			return null;
		}
		return this.examDao.getByLessonId(lessonId);

	}

	@Override
	public List<Exam> getByActive(int lessonId) {
		if (this.examDao.getByActive(lessonId).size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
			return null;
		}
		return this.examDao.getByActive(lessonId);
	}

}
