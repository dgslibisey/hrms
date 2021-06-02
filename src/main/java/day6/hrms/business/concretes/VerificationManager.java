package day6.hrms.business.concretes;

import day6.hrms.business.abstracts.VerificationService;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.core.utilities.results.SuccessResult;
import day6.hrms.dataAccess.abstracts.VerificationDao;
import day6.hrms.entities.concretes.Verification;

public class VerificationManager implements VerificationService {

	private VerificationDao verificationDao;

	public VerificationManager(VerificationDao verificationDao) {
		super();
		this.verificationDao = verificationDao;
	}

	@Override
	public Result add(Verification verificationCode) {
		this.verificationDao.save(verificationCode);
		return new SuccessResult("Onay kodu eklendi");
	}

}
