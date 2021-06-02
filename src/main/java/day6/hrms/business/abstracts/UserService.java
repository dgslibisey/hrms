package day6.hrms.business.abstracts;

import java.util.List;

import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.entities.concretes.User;

public interface UserService {

	Result add(User user);
	DataResult<List<User>> getAll();
	DataResult<User> findByEmail(String email);

	
}
