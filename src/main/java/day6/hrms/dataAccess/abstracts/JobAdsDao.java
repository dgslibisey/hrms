package day6.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import day6.hrms.entities.concretes.JobAds;

public interface JobAdsDao extends JpaRepository<JobAds, Integer> {

	JobAds getByjobName(String jobName);
	
	JobAds getByjobCity(String jobCity);
	
}
