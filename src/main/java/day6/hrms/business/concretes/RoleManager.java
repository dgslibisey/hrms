package day6.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day6.hrms.business.abstracts.RoleService;
import day6.hrms.core.results.DataResult;
import day6.hrms.core.results.Result;
import day6.hrms.dataAccess.abstracts.RoleDao;
import day6.hrms.entities.concretes.Role;
import lombok.Data;

@Data
@Service
public class RoleManager implements RoleService {

	private RoleDao roleDao;

	@Autowired
	public RoleManager(RoleDao roleDao) {
		super();
		this.roleDao = roleDao;
	}

	@Override
	public DataResult<List<Role>> getAll() {
		return this.getAll();
	}

	@Override
	public Result add(Role role) {
		return this.add(role);
	}
}
