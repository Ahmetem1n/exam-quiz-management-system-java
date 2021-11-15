package ExamQuizManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamQuizManagementSystem.business.abstracts.AdminService;
import ExamQuizManagementSystem.dataAccess.abstracts.AdminDao;
import ExamQuizManagementSystem.entities.concretes.Admin;

@Service
public class AdminManager implements AdminService {
	private AdminDao adminDao;

	@Autowired
	public AdminManager(AdminDao adminDao) {
		super();
		this.adminDao = adminDao;
	}

	@Override
	public void add(Admin admin) {
		if (adminDao.getByAdminId(admin.adminId) == null) {
			this.adminDao.save(admin);
			System.out.println("Ekleme işlemi yapıldı.");
		} else {
			System.out.println("Bu id ile zaten kayıt var. Ekleme yapılmadı.");
		}
	}

	@Override
	public void delete(Admin admin) {
		if (adminDao.getByAdminId(admin.adminId) != null) {
			this.adminDao.delete(admin);
			System.out.println("Silme işlemi yapıldı.");
		} else {
			System.out.println("Böyle bir kayıt bulunamadı. Silme yapılmadı.");
		}
	}

	@Override
	public void update(Admin admin) {
		if (adminDao.getByAdminId(admin.adminId) != null) {
			this.adminDao.save(admin);
			System.out.println("Güncelleme işlemi yapıldı.");
		} else {
			System.out.println("Böyle bir kayıt bulunamadı. Güncelleme yapılmadı.");
		}
	}

	@Override
	public List<Admin> getAll() {
		if (this.adminDao.findAll().size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
		}
		return this.adminDao.findAll();
	}

	@Override
	public Admin getByAdminId(int adminId) {
		if (this.adminDao.getByAdminId(adminId) == null) {
			System.out.println("Bu id ile kayıt bulunamadı.");
		}
		return this.adminDao.getByAdminId(adminId);
	}

}
