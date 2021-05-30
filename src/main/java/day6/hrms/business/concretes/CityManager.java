package day6.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import day6.hrms.business.abstracts.CityService;
import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.core.utilities.results.SuccessDataResult;
import day6.hrms.dataAccess.abstracts.CityDao;
import day6.hrms.entities.concretes.City;

public class CityManager implements CityService{

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}
	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}


}
