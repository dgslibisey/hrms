package day6.hrms.business.abstracts;

import java.util.List;

import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.entities.concretes.StaffUser;

public interface StaffUserService {

	Result add(StaffUser staffUser);
	DataResult<List<StaffUser>> getAll();
	DataResult<StaffUser> getByRoleId(Integer roleId);
	DataResult<StaffUser> getByFirstName(String firstName);
	DataResult<StaffUser> getByLastName(String lastName);
}
