package day6.hrms.business.abstracts;

import java.util.List;

import day6.hrms.core.results.DataResult;
import day6.hrms.core.results.Result;
import day6.hrms.entities.concretes.JobSeekerUser;

public interface JobSeekerUserService {

	DataResult<List<JobSeekerUser>> getAll();
	Result add(JobSeekerUser jobSeekerUser);
	
}
