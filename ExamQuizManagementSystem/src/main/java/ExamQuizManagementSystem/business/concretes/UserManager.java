package ExamQuizManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamQuizManagementSystem.business.abstracts.UserService;
import ExamQuizManagementSystem.dataAccess.abstracts.UserDao;
import ExamQuizManagementSystem.entities.concretes.User;

@Service
public class UserManager implements UserService {
	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		if (userDao.getByUserId(user.getUserId()) == null) {
			this.userDao.save(user);
			System.out.println("Ekleme işlemi yapıldı.");
			return;
		}
		System.out.println("Bu id ile zaten kayıt var. Ekleme yapılmadı.");

	}

	@Override
	public void delete(User user) {
		if (userDao.getByUserId(user.getUserId()) != null) {
			this.userDao.delete(user);
			System.out.println("Silme işlemi yapıldı.");
			return;

		}
		System.out.println("Böyle bir kayıt bulunamadı. Silme yapılmadı.");

	}

	@Override
	public void update(User user) {
		if (userDao.getByUserId(user.getUserId()) != null) {
			this.userDao.save(user);
			System.out.println("Güncelleme işlemi yapıldı.");
			return;
		}
		System.out.println("Böyle bir kayıt bulunamadı. Güncelleme yapılmadı.");

	}

	@Override
	public List<User> getAll() {
		if (this.userDao.findAll().size() == 0) {
			System.out.println("Listede hiç kayıt yok.");
			return null;
		}
		return this.userDao.findAll();
	}

	@Override
	public User getByUserId(int userId) {
		if (this.userDao.getByUserId(userId) == null) {
			System.out.println("Bu id ile kayıt bulunamadı.");
			return null;
		}
		return this.userDao.getByUserId(userId);
	}

	@Override
	public User login(String nationalityId, String userPassword) {
		if (this.userDao.loginUser(nationalityId, userPassword) == null) {
			System.out.println("Bu id ile kayıt bulunamadı.");
			return null;
		}
		return this.userDao.loginUser(nationalityId, userPassword);
	}

}
