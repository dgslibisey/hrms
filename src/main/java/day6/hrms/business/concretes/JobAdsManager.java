package day6.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day6.hrms.business.abstracts.JobAdsService;
import day6.hrms.core.utilities.results.DataResult;
import day6.hrms.core.utilities.results.ErrorResult;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.core.utilities.results.SuccessDataResult;
import day6.hrms.core.utilities.results.SuccessResult;
import day6.hrms.dataAccess.abstracts.JobAdsDao;
import day6.hrms.entities.concretes.JobAds;

@Service
public class JobAdsManager implements JobAdsService {

	@Autowired
	public JobAdsManager(JobAdsDao jobAdsDao) {
		super();
		this.jobAdsDao = jobAdsDao;
	}

	private JobAdsDao jobAdsDao;

	@Override
	public Result add(JobAds jobAds) {
		if (!CheckIfNullField(jobAds)) {
			return new ErrorResult("Eksik bilgi girişi yaptınız. Lütfen tüm alanları doldurduğunuzdan emin olunuz.");
		}
		this.jobAdsDao.save(jobAds);
		return new SuccessResult("Job advert has been added.");
	};
	
	
	private boolean CheckIfNullField(JobAds jobAds) {
		if (jobAds.getJobPosition() != null && jobAds.getJobDefinition() != null && jobAds.getCity() != null
				&& jobAds.getOpenPosition() != 0) {
			return true;
		}
		return false;
	}
	

	@Override
	public Result delete(int id) {
		this.jobAdsDao.deleteById(id);
		return new SuccessResult("İş ilanı silindi");
	}

	@Override
	public Result changeOpenToClose(int id) {
		if (getById(id) == null) {
			return new ErrorResult("Bu id ile bir iş ilanı bulunamadı");

		}
		if (getById(id).getData().isOpen() == false) {
			return new ErrorResult("Bu iş ilanı zaten kapalı");
		}

		JobAds jobAds = getById(id).getData();
		jobAds.setOpen(false);
		return new SuccessResult("İş ilanı kapatıldı.");
	}

	@Override
	public DataResult<JobAds> getById(int id) {
		return new SuccessDataResult<JobAds>(this.jobAdsDao.getById(id));

	}

	@Override
	public DataResult<List<JobAds>> getAll() {
		return new SuccessDataResult<List<JobAds>>(this.jobAdsDao.findAll(), true, "İş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobAds>> getAllOpenJobAdsList() {
		return new SuccessDataResult<List<JobAds>>(this.jobAdsDao.getAllOpenJobAdsList());
	}

	@Override
	public DataResult<List<JobAds>> findAllByOrderByPublishedAt() {
		return new SuccessDataResult<List<JobAds>>(this.jobAdsDao.findAllByOrderByPublishedAtDesc());
	}

	@Override
	public DataResult<List<JobAds>> getAllOpenJobAdsByEmployerUser(int id) {
		return new SuccessDataResult<List<JobAds>>(this.jobAdsDao.getAllOpenJobAdsByEmployerUser(id));
	}


}
