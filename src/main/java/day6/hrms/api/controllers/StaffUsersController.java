package day6.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import day6.hrms.business.abstracts.StaffUserService;
import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.entities.concretes.StaffUser;


@RestController
@RequestMapping("/api/staffusers")
public class StaffUsersController {
	
	private StaffUserService staffUserService;
	
	@Autowired
	public StaffUsersController(StaffUserService staffUserService) {
		super();
		this.staffUserService = staffUserService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody StaffUser staffUser) {
		return this.staffUserService.add(staffUser);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<StaffUser>> getAll(){
		return this.staffUserService.getAll();
	};
	
	@GetMapping("/getByRoleId")
	public DataResult<StaffUser> getByRoleId(Integer roleId) {
		return this.staffUserService.getByRoleId(roleId);
	}

	@GetMapping("/getByFirstName")
	public DataResult<StaffUser> getByFirstName(String firstName){
		return this.staffUserService.getByFirstName(firstName);
	};
	
	@GetMapping("/getByLastName")
	public DataResult<StaffUser> getByLastName(String lastName){
		return this.staffUserService.getByLastName(lastName);
	};	
}
