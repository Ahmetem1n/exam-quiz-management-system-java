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
		if (examDao.getByExamId(exam.examId) == null) {
			this.examDao.save(exam);
			System.out.println("Ekleme işlemi yapıldı.");
		} else {
			System.out.println("Bu id ile zaten kayıt var. Ekleme yapılmadı.");
		}
	}

	@Override
	public void delete(Exam exam) {
		if (examDao.getByExamId(exam.examId) != null) {
			this.examDao.delete(exam);
			System.out.println("Silme işlemi yapıldı.");
		} else {
			System.out.println("Böyle bir kayıt bulunamadı. Silme yapılmadı.");
		}
	}

	@Override
	public void update(Exam exam) {
		if (examDao.getByExamId(exam.examId) != null) {
			this.examDao.save(exam);
			System.out.println("Güncelleme işlemi yapıldı.");
		} else {
			System.out.println("Böyle bir kayıt bulunamadı. Güncelleme yapılmadı.");
		}
	}

	@Override
	public List<Exam> getAll() {
		if (this.examDao.findAll().size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
		}
		return this.examDao.findAll();
	}

	@Override
	public Exam getByExamId(int examId) {
		if (this.examDao.getByExamId(examId) == null) {
			System.out.println("Bu id ile kayıt bulunamadı.");
		}
		return this.examDao.getByExamId(examId);
	}

}
