package day6.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import day6.hrms.business.abstracts.AuthService;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.entities.concretes.EmployerUser;
import day6.hrms.entities.concretes.JobSeekerUser;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/registerEmployer")
	public Result registerEmpolyer(@RequestBody EmployerUser employerUser, String confirmPassword)
	{
		return authService.registerEmployerUser(employerUser, confirmPassword);
	}
	
	@PostMapping("/registerJobseeker")
	public Result registerJobseeker(@RequestBody JobSeekerUser jobSeekerUser, String confirmPassword)
	{
		return authService.registerJobSeekerUser(jobSeekerUser, confirmPassword);
	}
}