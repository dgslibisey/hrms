package day6.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day6.hrms.business.abstracts.UserService;
import day6.hrms.core.results.DataResult;
import day6.hrms.core.results.SuccessDataResult;
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
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>
		(this.userDao.findAll(), "Data listelendi");
	}

}
