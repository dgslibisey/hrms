package day6.hrms.business.abstracts;

import day6.hrms.core.utilities.results.Result;
import day6.hrms.entities.concretes.EmployerUser;
import day6.hrms.entities.concretes.JobSeekerUser;

public interface AuthService {

	public Result registerEmployerUser(EmployerUser employerUser, String confirmPassword) {
		return null;
	}
	public Result registerJobSeekerUser(JobSeekerUser jobseekerUsers, String confirmPassword) {
		return null;
	}
}
