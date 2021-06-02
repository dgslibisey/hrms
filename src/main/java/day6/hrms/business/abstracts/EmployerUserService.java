package day6.hrms.business.abstracts;

import java.util.List;

import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.entities.concretes.EmployerUser;

public interface EmployerUserService {

	DataResult<List<EmployerUser>> getAll();
	Result add(EmployerUser employerUser);
	DataResult<EmployerUser> findEmployerByCompanyName(String companyName);
	DataResult<EmployerUser> getEmployerById(int id);
}
