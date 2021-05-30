package day6.hrms.business.abstracts;

import java.util.List;

import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.entities.concretes.JobAds;

public interface JobAdsService {

	Result add(JobAds JobAds);
	Result update(JobAds JobAds);
	Result delete(int id);
	Result changeOpenToClose(int id);
	DataResult<JobAds> getById(int id);	
	DataResult<List<JobAds>> getAll();
	DataResult<List<JobAds>> getAllOpenJobAdsList();
	DataResult<List<JobAds>> findAllByOrderByPublishedAt();
	DataResult<List<JobAds>> getAllOpenJobAdvertByEmployerUser(int id);
}
