package ExamQuizManagementSystem.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamQuizManagementSystem.business.abstracts.LessonService;
import ExamQuizManagementSystem.business.abstracts.StudentLessonRelationshipService;
import ExamQuizManagementSystem.dataAccess.abstracts.StudentLessonRelationshipDao;
import ExamQuizManagementSystem.entities.concretes.Lesson;
import ExamQuizManagementSystem.entities.concretes.StudentLessonRelationship;

@Service
public class StudentLessonRelationshipManager implements StudentLessonRelationshipService {

	private StudentLessonRelationshipDao relationshipDao;

	@Autowired
	public StudentLessonRelationshipManager(StudentLessonRelationshipDao relationshipDao) {
		super();
		this.relationshipDao = relationshipDao;
	}

	@Autowired
	private LessonService lessonService;

	@Override
	public void add(StudentLessonRelationship relationship) {
		if (relationshipDao.getByRelationshipId(relationship.getRelationshipId()) == null) {

			this.relationshipDao.save(relationship);
			System.out.println("Ekleme işlemi yapıldı.");
		} else {
			System.out.println("Bu id ile zaten kayıt var veya yanlış bilgiler var. Ekleme yapılmadı.");
		}

	}

	@Override
	public void delete(StudentLessonRelationship relationship) {
		if (relationshipDao.getByRelationshipId(relationship.getRelationshipId()) != null) {
			this.relationshipDao.delete(relationship);
			System.out.println("Silme işlemi yapıldı.");
		} else {
			System.out.println("Böyle bir kayıt bulunamadı. Silme yapılmadı.");
		}

	}

	@Override
	public void update(StudentLessonRelationship relationship) {
		if (relationshipDao.getByRelationshipId(relationship.getRelationshipId()) != null) {
			this.relationshipDao.save(relationship);
			System.out.println("Güncelleme işlemi yapıldı.");
		} else {
			System.out.println("Böyle bir kayıt bulunamadı veya yanlış bilgiler var. Güncelleme yapılmadı.");
		}

	}

	@Override
	public List<StudentLessonRelationship> getAll() {
		List<StudentLessonRelationship> relationshipDataList = relationshipDao.findAll();
		if (relationshipDataList.size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
			return null;
		}

		return relationshipDataList;
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
		List<Lesson> lessonDataList = lessonService.getByTeacherId(teacherId);
		List<StudentLessonRelationship> relationshipDataList = relationshipDao.findAll();
		if (relationshipDataList.size() == 0 || lessonDataList.size() == 0) {
			return null;
		}
		List<StudentLessonRelationship> dataList = new ArrayList<StudentLessonRelationship>();
		for (int i = 0; i < lessonDataList.size(); i++) {
			for (int j = 0; j < relationshipDataList.size(); j++) {
				if (lessonDataList.get(i).getLessonId() == relationshipDataList.get(i).getLesson().getLessonId()) {
					dataList.add(relationshipDataList.get(i));
				}
			}
		}

		return dataList;
	}

}
