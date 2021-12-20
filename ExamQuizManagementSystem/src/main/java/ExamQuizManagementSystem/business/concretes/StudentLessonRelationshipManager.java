package ExamQuizManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamQuizManagementSystem.business.abstracts.StudentLessonRelationshipService;
import ExamQuizManagementSystem.dataAccess.abstracts.StudentLessonRelationshipDao;
import ExamQuizManagementSystem.entities.concretes.StudentLessonRelationship;

@Service
public class StudentLessonRelationshipManager implements StudentLessonRelationshipService {

	private StudentLessonRelationshipDao relationshipDao;

	@Autowired
	public StudentLessonRelationshipManager(StudentLessonRelationshipDao relationshipDao) {
		super();
		this.relationshipDao = relationshipDao;
	}

	@Override
	public void add(StudentLessonRelationship relationship) {
		if (relationshipDao.getByRelationshipId(relationship.getRelationshipId()) == null) {
			this.relationshipDao.save(relationship);
			System.out.println("Ekleme işlemi yapıldı.");
			return;
		}
		System.out.println("Bu id ile zaten kayıt var veya yanlış bilgiler var. Ekleme yapılmadı.");

	}

	@Override
	public void delete(StudentLessonRelationship relationship) {
		if (relationshipDao.getByRelationshipId(relationship.getRelationshipId()) != null) {
			this.relationshipDao.delete(relationship);
			System.out.println("Silme işlemi yapıldı.");
			return;
		}
		System.out.println("Böyle bir kayıt bulunamadı. Silme yapılmadı.");

	}

	@Override
	public void update(StudentLessonRelationship relationship) {
		if (relationshipDao.getByRelationshipId(relationship.getRelationshipId()) != null) {
			this.relationshipDao.save(relationship);
			System.out.println("Güncelleme işlemi yapıldı.");
			return;
		}
		System.out.println("Böyle bir kayıt bulunamadı veya yanlış bilgiler var. Güncelleme yapılmadı.");

	}

	@Override
	public List<StudentLessonRelationship> getAll() {
		if (this.relationshipDao.findAll().size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
			return null;
		}

		return this.relationshipDao.findAll();
	}

	@Override
	public StudentLessonRelationship getByRelationshipId(int relationshipId) {
		if (this.relationshipDao.getByRelationshipId(relationshipId) == null) {
			System.out.println("Bu id ile kayıt bulunamadı.");
			return null;
		}

		return relationshipDao.getByRelationshipId(relationshipId);
	}

	@Override
	public List<StudentLessonRelationship> getByStudentId(int studentId) {
		if (this.relationshipDao.getByStudentId(studentId) == null) {
			System.out.println("Kayıt bulunamadı.");
			return null;
		}
		return this.relationshipDao.getByStudentId(studentId);
	}

	public List<StudentLessonRelationship> getByLessonId(int lessonId) {
		if (this.relationshipDao.getByLessonId(lessonId) == null) {
			System.out.println("Kayıt bulunamadı.");
			return null;
		}
		return this.relationshipDao.getByLessonId(lessonId);
	}

	@Override
	public List<StudentLessonRelationship> getByTeacher(int teacherId) {
		if (this.relationshipDao.getByTeacher(teacherId) == null) {
			System.out.println("Kayıt bulunamadı.");
			return null;
		}
		return this.relationshipDao.getByTeacher(teacherId);
	}

}
