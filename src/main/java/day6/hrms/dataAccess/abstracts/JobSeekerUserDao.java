package day6.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import day6.hrms.entities.concretes.JobSeekerUser;

public interface JobSeekerUserDao extends JpaRepository<JobSeekerUser, Integer> {
	
	JobSeekerUser findByFirstName(String firstName);
	JobSeekerUser findByNationalIdentity(String nationalIdentity);
	
	//Mail doğrulama için arama yapabilme
	JobSeekerUser findByEmail(String mail);

}
