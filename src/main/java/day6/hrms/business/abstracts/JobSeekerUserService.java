package day6.hrms.business.abstracts;

import java.util.List;

import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.entities.concretes.JobSeekerUser;

public interface JobSeekerUserService {

	DataResult<List<JobSeekerUser>> getAll();
	DataResult<JobSeekerUser> getJobseekerByNationalId(String nationalId);
	Result add(JobSeekerUser jobSeekerUser);
	
}
