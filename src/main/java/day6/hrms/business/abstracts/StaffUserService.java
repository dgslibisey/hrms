package day6.hrms.business.abstracts;

import java.util.List;

import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.entities.concretes.StaffUser;

public interface StaffUserService {

	DataResult<List<StaffUser>> getAll();
}
