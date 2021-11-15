package ExamQuizManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamQuizManagementSystem.business.abstracts.TeacherService;
import ExamQuizManagementSystem.dataAccess.abstracts.TeacherDao;
import ExamQuizManagementSystem.entities.concretes.Teacher;

@Service
public class TeacherManager implements TeacherService {
	private TeacherDao teacherDao;

	@Autowired
	public TeacherManager(TeacherDao teacherDao) {
		super();
		this.teacherDao = teacherDao;
	}

	@Override
	public void add(Teacher teacher) {
		if (teacherDao.getByTeacherId(teacher.teacherId) == null) {
			this.teacherDao.save(teacher);
			System.out.println("Ekleme işlemi yapıldı.");
		} else {
			System.out.println("Bu id ile zaten kayıt var. Ekleme yapılmadı.");
		}
	}

	@Override
	public void delete(Teacher teacher) {
		if (teacherDao.getByTeacherId(teacher.teacherId) != null) {
			this.teacherDao.delete(teacher);
			System.out.println("Silme işlemi yapıldı.");
		} else {
			System.out.println("Böyle bir kayıt bulunamadı. Silme yapılmadı.");
		}
	}

	@Override
	public void update(Teacher teacher) {
		if (teacherDao.getByTeacherId(teacher.teacherId) != null) {
			this.teacherDao.save(teacher);
			System.out.println("Güncelleme işlemi yapıldı.");
		} else {
			System.out.println("Böyle bir kayıt bulunamadı. Güncelleme yapılmadı.");
		}
	}

	@Override
	public List<Teacher> getAll() {
		if (this.teacherDao.findAll().size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
		}
		return this.teacherDao.findAll();
	}

	@Override
	public Teacher getByTeacherId(int teacherId) {
		if (this.teacherDao.getByTeacherId(teacherId) == null) {
			System.out.println("Bu id ile kayıt bulunamadı.");
		}
		return this.teacherDao.getByTeacherId(teacherId);
	}

}
