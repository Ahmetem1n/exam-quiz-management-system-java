package ExamQuizManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamQuizManagementSystem.business.abstracts.DepartmentService;
import ExamQuizManagementSystem.dataAccess.abstracts.DepartmentDao;
import ExamQuizManagementSystem.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService {

	private DepartmentDao departmentDao;

	@Autowired
	public DepartmentManager(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}

	@Override
	public void add(Department department) {
		if (departmentDao.getByDepartmentId(department.getDepartmentId()) == null) {
			this.departmentDao.save(department);
			System.out.println("Ekleme işlemi yapıldı.");
			return;
		}
		System.out.println("Bu id ile zaten kayıt var. Ekleme yapılmadı.");

	}

	@Override
	public void delete(Department department) {
		if (departmentDao.getById(department.getDepartmentId()) != null) {
			this.departmentDao.delete(department);
			System.out.println("Silme işlemi yapıldı.");
			return;
		}
		System.out.println("Böyle bir kayıt bulunamadı. Silme yapılmadı.");

	}

	@Override
	public void update(Department department) {
		if (departmentDao.getByDepartmentId(department.getDepartmentId()) != null) {
			this.departmentDao.save(department);
			System.out.println("Güncelleme işlemi yapıldı.");
			return;
		}
		System.out.println("Böyle bir kayıt bulunamadı. Güncelleme yapılmadı.");

	}

	@Override
	public List<Department> getAll() {
		if (this.departmentDao.findAll().size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
			return null;
		}
		return this.departmentDao.findAll();
	}

	@Override
	public Department getByDepartmentId(int departmentId) {
		if (this.departmentDao.getByDepartmentId(departmentId) == null) {
			System.out.println("Bu id ile kayıt bulunamadı.");
			return null;
		}
		return this.departmentDao.getByDepartmentId(departmentId);
	}

}
