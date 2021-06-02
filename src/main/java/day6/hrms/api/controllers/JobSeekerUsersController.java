package day6.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import day6.hrms.business.abstracts.JobSeekerUserService;
import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.core.utilities.results.SuccessDataResult;
import day6.hrms.entities.concretes.JobSeekerUser;

@RestController
@RequestMapping("/api/jobseekerusers")
public class JobSeekerUsersController {

	private JobSeekerUserService jobSeekerUserService;

	@Autowired
	public JobSeekerUsersController(JobSeekerUserService jobSeekerUserService) {
		super();
		this.jobSeekerUserService = jobSeekerUserService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobSeekerUser>> getAll() {
		return this.jobSeekerUserService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerUser jobSeekerUser) {
		return this.jobSeekerUserService.add(jobSeekerUser);
	}
	
	@PostMapping("/findJobSeekerByFirstName")
	public DataResult<JobSeekerUser> findJobSeekerByFirstName(String firstName){
		return this.findJobSeekerByFirstName(firstName);
	};
	
	@PostMapping("/findJobSeekerByLastName")
	public DataResult<JobSeekerUser> findJobSeekerByLastName(String lastName){
		return this.findJobSeekerByFirstName(lastName);
	};
	
	@PostMapping("/findJobSeekerByNationalId")
	public DataResult<JobSeekerUser> findJobSeekerByNationalId(String nationalId){
		return this.findJobSeekerByNationalId(nationalId);
	};
	
	@PostMapping("/findJobSeekerByEmail")
	public DataResult<JobSeekerUser> findJobSeekerByEmail(String email){
		return this.findJobSeekerByEmail(email);
	};
	
	@PostMapping("/findJobSeekerByVerify")
	public DataResult<JobSeekerUser> findJobSeekerByVerify(Boolean isVerified){
		return new SuccessDataResult<JobSeekerUser>();
	};

}
