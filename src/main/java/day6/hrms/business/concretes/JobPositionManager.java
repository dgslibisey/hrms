package day6.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day6.hrms.business.abstracts.JobPositionService;
import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.core.utilities.results.ErrorResult;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.core.utilities.results.SuccessDataResult;
import day6.hrms.core.utilities.results.SuccessResult;
import day6.hrms.dataAccess.abstracts.JobPositionDao;
import day6.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(getJobByName(jobPosition.getName()).getData() != null){
			return new ErrorResult(jobPosition.getName() + " iş pozisyonu sistemde kayıtlı");
		}
		this.jobPositionDao.save(jobPosition);
	    return new SuccessResult("İş pozisyonu eklendi.");
	}


	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
	}

	public DataResult<JobPosition> getJobByName(String name) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.getJobByName(name));
	}

}