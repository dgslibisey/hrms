package day6.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day6.hrms.business.abstracts.JobSeekerUserService;
import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.core.utilities.results.SuccessDataResult;
import day6.hrms.core.utilities.results.SuccessResult;
import day6.hrms.dataAccess.abstracts.JobSeekerUserDao;
import day6.hrms.entities.concretes.JobSeekerUser;

@Service
public class JobSeekerUserManager implements JobSeekerUserService {

	private JobSeekerUserDao jobseekerUserDao;

	@Autowired
	public JobSeekerUserManager(JobSeekerUserDao jobseekerUserDao) {
		super();
		this.jobseekerUserDao = jobseekerUserDao;
	}

	@Override
	public Result add(JobSeekerUser jobseekerUser) {
		this.jobseekerUserDao.save(jobseekerUser);
      return new SuccessResult("Aday kullanıcı eklendi.");
	}

	@Override
	public DataResult<List<JobSeekerUser>> getAll() {
		return new SuccessDataResult<List<JobSeekerUser>>(this.jobseekerUserDao.findAll());

	} 

	@Override
	public DataResult<JobSeekerUser> findJobSeekerByFirstName(String firstName) {
		return new SuccessDataResult<JobSeekerUser>(this.jobseekerUserDao.findJobSeekerByFirstName(firstName));
	}

	@Override
	public DataResult<JobSeekerUser> findJobSeekerByLastName(String lastName) {
		return new SuccessDataResult<JobSeekerUser>(this.jobseekerUserDao.findJobSeekerByLastName(lastName));
	}

	@Override
	public DataResult<JobSeekerUser> findJobSeekerByNationalId(String nationalId) {
		return new SuccessDataResult<JobSeekerUser>(this.jobseekerUserDao.findJobSeekerByNationalId(nationalId));
	}

	@Override
	public DataResult<JobSeekerUser> findJobSeekerByEmail(String email) {
		return new SuccessDataResult<JobSeekerUser>(this.jobseekerUserDao.findJobSeekerByEmail(email));
	}

	@Override
	public DataResult<JobSeekerUser> findJobSeekerByVerify(Boolean isVerified) {
		return new SuccessDataResult<JobSeekerUser>(this.jobseekerUserDao.findJobSeekerByVerify(isVerified));
	}
}