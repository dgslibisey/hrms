package day6.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import day6.hrms.business.abstracts.RoleService;
import day6.hrms.dataAccess.abstracts.RoleDao;
import day6.hrms.entities.concretes.Role;


@Service
public class RoleManager implements RoleService {
	
	private RoleDao roleDao;
	
	public RoleManager(RoleDao roleDao) {
		super();
		this.roleDao = roleDao;
		
	}
	
	
	public List<Role> getAll() {
		return this.roleDao.findAll();
	}	
}
