package day6.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import day6.hrms.entities.concretes.JobSeekerUser;

public interface JobSeekerUserDao extends JpaRepository<JobSeekerUser, Integer> {
	
	JobSeekerUser findJobSeekerByFirstName(String firstName);
	JobSeekerUser findJobSeekerByLastName(String lastName);
	JobSeekerUser findJobSeekerByNationalId(String nationalId);
	JobSeekerUser findJobSeekerByEmail(String email);
	JobSeekerUser findJobSeekerByVerify(Boolean isVerified);

}
