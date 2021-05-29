package day6.hrms.business.abstracts;

import java.util.List;

import day6.hrms.core.results.DataResult;
import day6.hrms.entities.concretes.User;

public interface UserService {

	DataResult<List<User>> getAll();
	
}
