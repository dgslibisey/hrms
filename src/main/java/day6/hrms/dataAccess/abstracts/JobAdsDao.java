package day6.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import day6.hrms.entities.concretes.JobAds;

public interface JobAdsDao extends JpaRepository<JobAds, Integer> {

	@Query("From JobAds where isOpen = true")
	List<JobAds> getAllOpenJobAdsList();
	
	@Query("From JobAds where isOpen = true Order By publishedAt Desc")
	List<JobAds> findAllByOrderByPublishedAtDesc();
	
	@Query("From JobAds where isOpen = true and employer_id =:id")
	List<JobAds> getAllOpenJobAdsByEmployerUser(int id);

	JobAds getById(int id);
	
}