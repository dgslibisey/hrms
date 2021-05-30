package day6.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day6.hrms.business.abstracts.UserService;
import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.core.utilities.results.SuccessDataResult;
import day6.hrms.core.utilities.results.SuccessResult;
import day6.hrms.dataAccess.abstracts.UserDao;
import day6.hrms.entities.concretes.User;


@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public DataResult<List<User>> getAll(){
		return new SuccessDataResult<List<User>>
		(this.userDao.findAll(), false, "Data listelendi");
	}


	@Override
	public DataResult<User> getUserByEmail(String email) {

		return new SuccessDataResult<User>(this.userDao.findByEmail(email));
	}


	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi.");
	}
}
