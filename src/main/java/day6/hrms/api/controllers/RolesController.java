package day6.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import day6.hrms.business.abstracts.RoleService;
import day6.hrms.core.results.DataResult;
import day6.hrms.entities.concretes.Role;

@RestController
@RequestMapping("/api/roles")
public class RolesController {
	
	
	public RoleService roleService;
	
	@Autowired
	public RolesController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}


	@GetMapping("/getall")
	public DataResult<List<Role>> getAll() {
		return this.roleService.getAll();
	}
	
	
}
