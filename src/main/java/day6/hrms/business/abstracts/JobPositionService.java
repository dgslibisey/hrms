package day6.hrms.business.abstracts;

import java.util.List;

import day6.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	List<JobPosition> getAll();
	
}
