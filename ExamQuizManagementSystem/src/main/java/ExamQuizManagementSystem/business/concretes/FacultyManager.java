package ExamQuizManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamQuizManagementSystem.business.abstracts.FacultyService;
import ExamQuizManagementSystem.dataAccess.abstracts.FacultyDao;
import ExamQuizManagementSystem.entities.concretes.Faculty;

@Service
public class FacultyManager implements FacultyService {
	private FacultyDao facultyDao;

	@Autowired
	public FacultyManager(FacultyDao facultyDao) {
		super();
		this.facultyDao = facultyDao;
	}

	@Override
	public void add(Faculty faculty) {
		if (facultyDao.getByFacultyId(faculty.getFacultyId()) == null) {
			this.facultyDao.save(faculty);
			System.out.println("Ekleme işlemi yapıldı.");
			return;
		}
		System.out.println("Bu id ile zaten kayıt var. Ekleme yapılmadı.");
	}

	@Override
	public void delete(Faculty faculty) {
		if (facultyDao.getByFacultyId(faculty.getFacultyId()) != null) {
			this.facultyDao.delete(faculty);
			System.out.println("Silme işlemi yapıldı.");
			return;
		}
		System.out.println("Böyle bir kayıt bulunamadı. Silme yapılmadı.");
	}

	@Override
	public void update(Faculty faculty) {
		if (facultyDao.getByFacultyId(faculty.getFacultyId()) != null) {
			this.facultyDao.save(faculty);
			System.out.println("Güncelleme işlemi yapıldı.");
			return;
		}
		System.out.println("Böyle bir kayıt bulunamadı. Güncelleme yapılmadı.");
	}

	@Override
	public List<Faculty> getAll() {
		if (this.facultyDao.findAll().size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
		}
		return this.facultyDao.findAll();
	}

	@Override
	public Faculty getByFacultyId(int facultyId) {
		if (this.facultyDao.getByFacultyId(facultyId) == null) {
			System.out.println("Bu id ile kayıt bulunamadı.");
		}
		return this.facultyDao.getByFacultyId(facultyId);
	}

}
