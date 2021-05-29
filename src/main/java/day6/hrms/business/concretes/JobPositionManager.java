package day6.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day6.hrms.business.abstracts.JobPositionService;
import day6.hrms.core.results.DataResult;
import day6.hrms.core.results.ErrorResult;
import day6.hrms.core.results.Result;
import day6.hrms.core.results.SuccessDataResult;
import day6.hrms.core.results.SuccessResult;
import day6.hrms.dataAccess.abstracts.JobPositionDao;
import day6.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.findAll(), "İş pozisyonları listelendi");
	}

	@Override
	public Result add(JobPosition jobPosition) {

		if(this.jobPositionDao.findByName(jobPosition.getName()) != null ) {
			return new ErrorResult("Aynı isimli iş pozisyonu mevcut");
		}else {
		
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("İş pozisyonu eklendi");
		}
	}

}