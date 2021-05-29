package day6.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import day6.hrms.business.abstracts.EmployerUserService;
import day6.hrms.core.results.DataResult;
import day6.hrms.core.results.Result;
import day6.hrms.entities.concretes.EmployerUser;

@RestController
@RequestMapping("/api/employerusers")
public class EmployerUserController {

	private EmployerUserService employerUserService;
	
	@Autowired
	public EmployerUserController(EmployerUserService employerUserService) {
		super();
		this.employerUserService = employerUserService;
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<EmployerUser>> getAll() {
		return this.employerUserService.getAll();
	}
	
	@PostMapping
	public Result add(@RequestBody EmployerUser employerUser) {
		return this.employerUserService.add(employerUser);
	}
	
}
