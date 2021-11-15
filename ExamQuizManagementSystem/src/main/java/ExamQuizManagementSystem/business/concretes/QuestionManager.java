package ExamQuizManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamQuizManagementSystem.business.abstracts.QuestionService;
import ExamQuizManagementSystem.dataAccess.abstracts.QuestionDao;
import ExamQuizManagementSystem.entities.concretes.Question;

@Service
public class QuestionManager implements QuestionService {
	private QuestionDao questionDao;

	@Autowired
	public QuestionManager(QuestionDao questionDao) {
		super();
		this.questionDao = questionDao;
	}

	@Override
	public void add(Question question) {
		if (questionDao.getByQuestionId(question.questionId) == null) {
			this.questionDao.save(question);
			System.out.println("Ekleme işlemi yapıldı.");
		} else {
			System.out.println("Bu id ile zaten kayıt var. Ekleme yapılmadı.");
		}
	}

	@Override
	public void delete(Question question) {
		if (questionDao.getByQuestionId(question.questionId) != null) {
			this.questionDao.delete(question);
			System.out.println("Silme işlemi yapıldı.");
		} else {
			System.out.println("Böyle bir kayıt bulunamadı. Silme yapılmadı.");
		}
	}

	@Override
	public void update(Question question) {
		if (questionDao.getByQuestionId(question.questionId) != null) {
			this.questionDao.save(question);
			System.out.println("Güncelleme işlemi yapıldı.");
		} else {
			System.out.println("Böyle bir kayıt bulunamadı. Güncelleme yapılmadı.");
		}
	}

	@Override
	public List<Question> getAll() {
		if (this.questionDao.findAll().size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
		}
		return this.questionDao.findAll();
	}

	@Override
	public Question getByQuestionId(int questionId) {
		if (this.questionDao.getByQuestionId(questionId) == null) {
			System.out.println("Bu id ile kayıt bulunamadı.");
		}
		return this.questionDao.getByQuestionId(questionId);
	}

}
