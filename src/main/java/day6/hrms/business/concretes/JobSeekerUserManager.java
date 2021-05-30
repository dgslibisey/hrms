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
      return new SuccessResult("Jobseeker has been added.");
	}
	
	@Override
	public DataResult<List<JobSeekerUser>> getAll() {
		return new SuccessDataResult<List<JobSeekerUser>>(this.jobseekerUserDao.findAll());
	}

	@Override
	public DataResult<JobSeekerUser> getJobseekerByNationalId(String nationalId) {
		return new SuccessDataResult<JobSeekerUser>(this.jobseekerUserDao.findJobseekerByNationalId(nationalId));
	}
}