package day6.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day6.hrms.business.abstracts.JobSeekerUserService;
import day6.hrms.core.results.DataResult;
import day6.hrms.core.results.ErrorResult;
import day6.hrms.core.results.Result;
import day6.hrms.core.results.SuccessDataResult;
import day6.hrms.core.results.SuccessResult;
import day6.hrms.core.validation.EMailValidationService;
import day6.hrms.dataAccess.abstracts.JobSeekerUserDao;
import day6.hrms.dataAccess.abstracts.UserDao;
import day6.hrms.entities.concretes.JobSeekerUser;

@Service
public class JobSeekerUserManager implements JobSeekerUserService {

	private JobSeekerUserDao jobSeekerUserDao;
	private UserDao userDao;
	private EMailValidationService eMailValidationService;

	@Autowired
	public JobSeekerUserManager(JobSeekerUserDao jobSeekerUserDao, UserDao userDao,
			EMailValidationService eMailValidationService) {
		super();
		this.jobSeekerUserDao = jobSeekerUserDao;
		this.userDao = userDao;
		this.eMailValidationService = eMailValidationService;
	}

	@Override
	public DataResult<List<JobSeekerUser>> getAll() {

		return new SuccessDataResult<List<JobSeekerUser>>(this.jobSeekerUserDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(JobSeekerUser jobSeekerUser) {

		if (jobSeekerUser.getEmail() == null || jobSeekerUser.getPassword() == null
				|| jobSeekerUser.getPasswordRepeat() == null || jobSeekerUser.getCreatedDate() == null
				|| jobSeekerUser.getFirstName() == null || jobSeekerUser.getLastName() == null
				|| jobSeekerUser.getNationalIdentity() == null || jobSeekerUser.getDateOfBirth() == null) {
			return new ErrorResult("Tüm alanları doldurunuz");
		}
		// şifre tekrarı, uyuşmaması halinde uyarı
		else if (!jobSeekerUser.getPassword().equals(jobSeekerUser.getPasswordRepeat())) {
			return new ErrorResult("Şifreler uyumsuz");
			// mail adresi kontrolü
		} else if (userDao.findByEmail(jobSeekerUser.getEmail()) != null) {
			return new ErrorResult(
					"Bu mail adresi kullanılmaktadır, lütfen başka bir mail adresi ile kayıt oluşturunuz");
		} else if (jobSeekerUserDao.findByNationalIdentity(jobSeekerUser.getNationalIdentity()) != null) {
			return new ErrorResult("Bu TC Kimlik No'ya ait kayıt bulunmaktadır");
		} else {

			if (eMailValidationService.sendMail(jobSeekerUser)) {
				jobSeekerUserDao.save(jobSeekerUser);
				return new SuccessResult("İş arayan kullanıcı kaydı oluşturuldu, doğrulama için e-posta gönderildi.");
			} else {
				return new ErrorResult("Doğrulamada hata oluştu, kayıt gerçekleştirilemedi");
			}

		}
	}
}