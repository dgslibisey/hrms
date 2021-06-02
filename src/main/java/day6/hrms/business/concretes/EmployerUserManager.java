package day6.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day6.hrms.business.abstracts.EmployerUserService;
import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.core.utilities.results.SuccessDataResult;
import day6.hrms.core.utilities.results.SuccessResult;
import day6.hrms.dataAccess.abstracts.EmployerUserDao;
import day6.hrms.entities.concretes.EmployerUser;

@Service
public class EmployerUserManager implements EmployerUserService {

	private EmployerUserDao employerUserDao;

	@Autowired
	public EmployerUserManager(EmployerUserDao employerUserDao) {
		super();
		this.employerUserDao = employerUserDao;
	}

	@Override
	public DataResult<List<EmployerUser>> getAll() {
		return new SuccessDataResult<List<EmployerUser>>(this.employerUserDao.findAll());
	}

	@Override
	public Result add(EmployerUser employerUser) {
		this.employerUserDao.save(employerUser);
		return new SuccessResult("İşveren eklendi.");
	}

	@Override
	public DataResult<EmployerUser> findEmployerByCompanyName(String companyName) {
		return new SuccessDataResult<EmployerUser>(this.employerUserDao.findEmployerByCompanyName(companyName));
	}

	@Override
	public DataResult<EmployerUser> getEmployerById(int id) {
		return new SuccessDataResult<EmployerUser>(this.employerUserDao.getEmployerById(id));
	}

}