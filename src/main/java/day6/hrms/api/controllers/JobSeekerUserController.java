package day6.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import day6.hrms.business.abstracts.JobSeekerUserService;
import day6.hrms.core.results.DataResult;
import day6.hrms.core.results.Result;
import day6.hrms.entities.concretes.JobSeekerUser;

@RestController
@RequestMapping("/api/jobseekerusers")
public class JobSeekerUserController {

	private JobSeekerUserService jobSeekerUserService;

	public JobSeekerUserController(JobSeekerUserService jobSeekerUserService) {
		super();
		this.jobSeekerUserService = jobSeekerUserService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobSeekerUser>> getAll() {
		return this.jobSeekerUserService.getAll();
	}

	public Result add(@RequestBody JobSeekerUser jobSeekerUser) {
		return this.jobSeekerUserService.add(jobSeekerUser);
	}

}
