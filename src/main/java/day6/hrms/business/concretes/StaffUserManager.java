package day6.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day6.hrms.business.abstracts.StaffUserService;
import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.core.utilities.results.SuccessDataResult;
import day6.hrms.core.utilities.results.SuccessResult;
import day6.hrms.dataAccess.abstracts.StaffUserDao;
import day6.hrms.entities.concretes.StaffUser;

@Service
public class StaffUserManager implements StaffUserService {

	private StaffUserDao staffUserDao;

	@Autowired
	public StaffUserManager(StaffUserDao staffUserDao) {
		this.staffUserDao = staffUserDao;
	}
	
	@Override
	public DataResult<List<StaffUser>> getAll() {
		return new SuccessDataResult<List<StaffUser>>(this.staffUserDao.findAll());
	}

	@Override
	public Result add(StaffUser staffUser) {
		this.staffUserDao.save(staffUser);
		return new SuccessResult("Sistem personeli eklendi.");
	}

	@Override
	public DataResult<StaffUser> getByRoleId(Integer roleId) {
		return new SuccessDataResult<StaffUser>(this.staffUserDao.getByRoleId(roleId));
	}

	@Override
	public DataResult<StaffUser> getByFirstName(String firstName) {
		return new SuccessDataResult<StaffUser>(this.staffUserDao.getByFirstName(firstName));
	}

	@Override
	public DataResult<StaffUser> getByLastName(String lastName) {
		return new SuccessDataResult<StaffUser>(this.staffUserDao.getByLastName(lastName));
	}

}
