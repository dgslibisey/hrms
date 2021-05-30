package day6.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day6.hrms.business.abstracts.StaffUserService;
import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.core.utilities.results.SuccessDataResult;
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
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<StaffUser>>(this.staffUserDao.findAll());
	}

}
