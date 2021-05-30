package day6.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import day6.hrms.business.abstracts.StaffUserService;
import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.entities.concretes.StaffUser;

@RestController
@RequestMapping("/api/staffuser")
public class StaffUserController {

	private StaffUserService staffUserService;
	
	@Autowired
	public StaffUserController(StaffUserService staffUserService) {
		super();
		this.staffUserService = staffUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<StaffUser>> getAll(){
		return this.staffUserService.getAll();
	}
}
