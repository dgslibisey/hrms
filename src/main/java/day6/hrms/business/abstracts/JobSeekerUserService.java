package day6.hrms.business.abstracts;

import java.util.List;

import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.entities.concretes.JobSeekerUser;

public interface JobSeekerUserService {

	DataResult<List<JobSeekerUser>> getAll();
	Result add(JobSeekerUser jobSeekerUser);
	DataResult<JobSeekerUser> findJobSeekerByFirstName(String firstName);
	DataResult<JobSeekerUser> findJobSeekerByLastName(String lastName);
	DataResult<JobSeekerUser> findJobSeekerByNationalId(String nationalId);
	DataResult<JobSeekerUser> findJobSeekerByEmail(String email);
	DataResult<JobSeekerUser> findJobSeekerByVerify(Boolean isVerified);
}
