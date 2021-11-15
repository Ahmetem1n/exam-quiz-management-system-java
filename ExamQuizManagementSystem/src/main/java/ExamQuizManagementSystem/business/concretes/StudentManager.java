package ExamQuizManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamQuizManagementSystem.business.abstracts.StudentService;
import ExamQuizManagementSystem.dataAccess.abstracts.StudentDao;
import ExamQuizManagementSystem.entities.concretes.Student;

@Service
public class StudentManager implements StudentService {
	private StudentDao studentDao;

	@Autowired
	public StudentManager(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	@Override
	public void add(Student student) {
		if (studentDao.getByStudentId(student.studentId) == null) {
			this.studentDao.save(student);
			System.out.println("Ekleme işlemi yapıldı.");
		} else {
			System.out.println("Bu id ile zaten kayıt var. Ekleme yapılmadı.");
		}
	}

	@Override
	public void delete(Student student) {
		if (studentDao.getByStudentId(student.studentId) != null) {
			this.studentDao.delete(student);
			System.out.println("Silme işlemi yapıldı.");
		} else {
			System.out.println("Böyle bir kayıt bulunamadı. Silme yapılmadı.");
		}
	}

	@Override
	public void update(Student student) {
		if (studentDao.getByStudentId(student.studentId) != null) {
			this.studentDao.save(student);
			System.out.println("Güncelleme işlemi yapıldı.");
		} else {
			System.out.println("Böyle bir kayıt bulunamadı. Güncelleme yapılmadı.");
		}
	}

	@Override
	public List<Student> getAll() {
		if (this.studentDao.findAll().size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
		}
		return this.studentDao.findAll();
	}

	@Override
	public Student getByStudentId(int studentId) {
		if (this.studentDao.getByStudentId(studentId) == null) {
			System.out.println("Bu id ile kayıt bulunamadı.");
		}
		return this.studentDao.getByStudentId(studentId);
	}

}
