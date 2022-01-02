package ExamQuizManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamQuizManagementSystem.business.abstracts.UserRoleService;
import ExamQuizManagementSystem.dataAccess.abstracts.UserRoleDao;
import ExamQuizManagementSystem.entities.concretes.UserRole;

@Service
public class UserRoleManager implements UserRoleService {
	private UserRoleDao userRoleDao;

	@Autowired
	public UserRoleManager(UserRoleDao userRoleDao) {
		super();
		this.userRoleDao = userRoleDao;
	}

	@Override
	public void add(UserRole userRole) {
		if (userRoleDao.getByRoleId(userRole.getRoleId()) == null) {
			this.userRoleDao.save(userRole);
			System.out.println("Ekleme işlemi yapıldı.");
			return;
		}
		System.out.println("Bu id ile zaten kayıt var. Ekleme yapılmadı.");

	}

	@Override
	public void delete(UserRole userRole) {
		if (userRoleDao.getByRoleId(userRole.getRoleId()) != null) {
			this.userRoleDao.delete(userRole);
			System.out.println("Silme işlemi yapıldı.");
			return;
		}
		System.out.println("Böyle bir kayıt bulunamadı. Silme yapılmadı.");

	}

	@Override
	public void update(UserRole userRole) {
		if (userRoleDao.getByRoleId(userRole.getRoleId()) != null) {
			this.userRoleDao.save(userRole);
			System.out.println("Güncelleme işlemi yapıldı.");
			return;
		}
		System.out.println("Böyle bir kayıt bulunamadı. Güncelleme yapılmadı.");

	}

	@Override
	public List<UserRole> getAll() {
		if (this.userRoleDao.findAll().size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
		}
		return this.userRoleDao.findAll();
	}

	@Override
	public UserRole getByRoleId(int roleId) {
		if (this.userRoleDao.getByRoleId(roleId) == null) {
			System.out.println("Bu id ile kayıt bulunamadı.");
		}
		return this.userRoleDao.getByRoleId(roleId);
	}

}
