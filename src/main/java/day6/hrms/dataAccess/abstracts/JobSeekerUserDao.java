package day6.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import day6.hrms.entities.concretes.JobSeekerUser;

public interface JobSeekerUserDao extends JpaRepository<JobSeekerUser, Integer> {
	
	JobSeekerUser findByName(String firstName);
	JobSeekerUser findByNationalIdentity(String nationalIdentity);
	
	//Mail doğrulama için arama yapabilme
	JobSeekerUser findByemail(String mail);

}
