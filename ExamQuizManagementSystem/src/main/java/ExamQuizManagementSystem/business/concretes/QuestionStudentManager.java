package ExamQuizManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamQuizManagementSystem.business.abstracts.QuestionStudentService;
import ExamQuizManagementSystem.dataAccess.abstracts.QuestionStudentDao;
import ExamQuizManagementSystem.entities.concretes.QuestionStudent;

@Service
public class QuestionStudentManager implements QuestionStudentService {

	private QuestionStudentDao questionStudentDao;

	@Autowired
	public QuestionStudentManager(QuestionStudentDao questionStudentDao) {
		super();
		this.questionStudentDao = questionStudentDao;
	}

	@Override
	public void add(QuestionStudent questionStudent) {
		List<QuestionStudent> questionStudentDataList = questionStudentDao.findAll();
		for (int i = 0; i < questionStudentDataList.size(); i++) {
			if (questionStudent.getQuestion().getQuestionId() == questionStudentDataList.get(i).getQuestion()
					.getQuestionId()
					&& questionStudent.getStudent().getStudentId() == questionStudentDataList.get(i).getStudent()
							.getStudentId()) {

				questionStudent.setDetailId(questionStudentDataList.get(i).getDetailId());
				this.questionStudentDao.save(questionStudent);
				System.out.println("değiştirildi");
				return;
			}
		}

		this.questionStudentDao.save(questionStudent);

	}

	@Override
	public void delete(QuestionStudent questionStudent) {
		if (questionStudentDao.getByDetailId(questionStudent.getDetailId()) != null) {
			this.questionStudentDao.delete(questionStudent);
			System.out.println("Silme işlemi yapıldı.");
			return;
		}
		System.out.println("Böyle bir kayıt bulunamadı. Silme yapılmadı.");

	}

	@Override
	public void update(QuestionStudent questionStudent) {

		if (questionStudentDao.getByDetailId(questionStudent.getDetailId()) != null) {
			this.questionStudentDao.save(questionStudent);
			System.out.println("Güncelleme işlemi yapıldı.");
			return;
		}
		System.out.println("Böyle bir kayıt bulunamadı veya yanlış bilgiler var. Güncelleme yapılmadı.");

	}

	@Override
	public List<QuestionStudent> getAll() {
		if (this.questionStudentDao.findAll().size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
		}

		return this.questionStudentDao.findAll();
	}

	@Override
	public QuestionStudent getByDetailId(int detailId) {
		if (this.questionStudentDao.getByDetailId(detailId) == null) {
			System.out.println("Bu id ile kayıt bulunamadı.");
		}

		return this.questionStudentDao.getByDetailId(detailId);
	}

}
