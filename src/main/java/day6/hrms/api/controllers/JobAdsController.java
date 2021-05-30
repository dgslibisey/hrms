package day6.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import day6.hrms.business.abstracts.JobAdsService;
import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.entities.concretes.JobAds;

@RestController
@RequestMapping("/api/jobads")
public class JobAdsController {

	private JobAdsController jobAdsService;

	@Autowired
	public JobAdsController(JobAdsService jobAdsService) {
		super();
		this.jobAdsService = (JobAdsController) jobAdsService;
	}

	
	@PostMapping("/add")
	
	public Result add(@RequestBody JobAds jobAds){
		return this.jobAdsService.add(jobAds);
	}

	@GetMapping("/getAll")
	public DataResult<List<JobAds>> getAll(){		
		return this.jobAdsService.getAll();
	}
	
	@PostMapping("/changeOpenToClose")
	public Result changeOpenToClose(int id){
		return this.jobAdsService.changeOpenToClose(id);
	}
	
	@GetMapping("/getAllOpenJobAdvertList")
	public DataResult<List<JobAds>> getAllOpenJobAdvertList(){
		return this.jobAdsService.getAllOpenJobAdvertList();
	}
	
	@GetMapping("/findAllByOrderByPublishedAt")
	public DataResult<List<JobAds>> findAllByOrderByPublishedAt(){
		return this.jobAdsService.findAllByOrderByPublishedAt();
	}
	
	@GetMapping("/getAllOpenJobAdvertByEmployer")
	public DataResult<List<JobAds>> getAllOpenJobAdvertByEmployer(int id){
		return this.jobAdsService.getAllOpenJobAdvertByEmployer(id);
	}
}
