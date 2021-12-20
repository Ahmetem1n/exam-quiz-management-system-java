package ExamQuizManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamQuizManagementSystem.business.abstracts.ExamResultService;
import ExamQuizManagementSystem.dataAccess.abstracts.ExamResultDao;
import ExamQuizManagementSystem.entities.concretes.ExamResult;

@Service
public class ExamResultManager implements ExamResultService {

	private ExamResultDao examResultDao;

	@Autowired
	public ExamResultManager(ExamResultDao examResultDao) {
		super();
		this.examResultDao = examResultDao;
	}

	@Override
	public void add(ExamResult examResult) {
		if (examResultDao.getByResultId(examResult.getResultId()) == null) {
			this.examResultDao.save(examResult);
			System.out.println("Ekleme işlemi yapıldı.");
		} else {
			System.out.println("Bu id ile zaten kayıt var. Ekleme yapılmadı.");
		}

	}

	@Override
	public void create(ExamResult examResult) {

	}

	@Override
	public void delete(ExamResult examResult) {
		if (examResultDao.getByResultId(examResult.getResultId()) != null) {
			this.examResultDao.delete(examResult);
			System.out.println("Silme işlemi yapıldı.");
		} else {
			System.out.println("Böyle bir kayıt bulunamadı. Silme yapılmadı.");
		}

	}

	@Override
	public void update(ExamResult examResult) {
		if (examResultDao.getByResultId(examResult.getResultId()) != null) {
			this.examResultDao.save(examResult);
			System.out.println("Güncelleme işlemi yapıldı.");
		} else {
			System.out.println("Böyle bir kayıt bulunamadı. Güncelleme yapılmadı.");
		}

	}

	@Override
	public List<ExamResult> getAll() {
		if (this.examResultDao.findAll().size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
		}
		return this.examResultDao.findAll();
	}

	@Override
	public ExamResult getByResultId(int resultId) {
		if (this.examResultDao.getByResultId(resultId) == null) {
			System.out.println("Bu id ile kayıt bulunamadı.");
		}
		return this.examResultDao.getByResultId(resultId);
	}

	@Override
	public List<ExamResult> getByStudentId(int studentId) {
		if (this.examResultDao.get(resultId) == null) {
			System.out.println("Bu id ile kayıt bulunamadı.");
		}
		return this.examResultDao.getByResultId(resultId);
	}

	@Override
	public ExamResult getByExamIdAndStudentId(int examId, int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
