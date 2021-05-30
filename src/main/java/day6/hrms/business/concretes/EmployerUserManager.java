package day6.hrms.business.concretes;
//e-posta doğrulaması ya da hrms personeli doğrulaması gerekli

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day6.hrms.business.abstracts.EmployerUserService;
import day6.hrms.core.results.DataResult;
import day6.hrms.core.results.ErrorResult;
import day6.hrms.core.results.Result;
import day6.hrms.core.results.SuccessDataResult;
import day6.hrms.core.results.SuccessResult;
import day6.hrms.core.validation.EMailValidationService;
import day6.hrms.core.validation.StaffValidationService;
import day6.hrms.dataAccess.abstracts.EmployerUserDao;
import day6.hrms.dataAccess.abstracts.UserDao;
import day6.hrms.entities.concretes.EmployerUser;

@Service
public class EmployerUserManager implements EmployerUserService {

	private EmployerUserDao employerUserDao;
	private UserDao userDao;
	private EMailValidationService eMailValidationService;
	private StaffValidationService staffValidationService;

	@Autowired
	public EmployerUserManager(EmployerUserDao employerUserDao, UserDao userDao,
			EMailValidationService eMailValidationService, StaffValidationService staffValidationService) {
		super();
		this.employerUserDao = employerUserDao;
		this.userDao = userDao;
		this.eMailValidationService = eMailValidationService;
		this.staffValidationService = staffValidationService;
	}

	@Override
	public DataResult<List<EmployerUser>> getAll() {

		return new SuccessDataResult<List<EmployerUser>>(this.employerUserDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(EmployerUser employerUser) {

// zorunlu alanlar 

		if (employerUser.getEmail() == null || employerUser.getPassword() == null
				|| employerUser.getPasswordRepeat() == null || employerUser.getCreatedDate() == null
				|| employerUser.getCompanyName() == null || employerUser.getWebSite() == null
				|| employerUser.getPhoneNumber() == null) {
			return new ErrorResult("Tüm alanları doldurunuz");
		}
		// parola tekrarı
		else if (!employerUser.getPassword().equals(employerUser.getPasswordRepeat())) {
			return new ErrorResult("Şifreler uyumsuz");
		}
		// e mail adresi web sitesi ile aynı domaini içermeli
		else if (!employerUser.getEmail()
				.contains("@" + employerUser.getEmail().substring(employerUser.getEmail().indexOf("@") + 1))) {
			return new ErrorResult("Mail adresiniz web sitenizin domain adresi ile aynı olmalıdır");
		}
		// mail adresi
		else if (userDao.findByEmail(employerUser.getEmail()) != null) {
			return new ErrorResult(
					"Bu e-posta adresi kullanılmaktadır, başka bir e-posta adresi ile kayıt oluşturmayı deneyiniz");
		} else {
			// e posta doğrulama için işverene e posta gönder
			if (eMailValidationService.sendMail(employerUser) && staffValidationService.staffValidated(employerUser)) {
				employerUserDao.save(employerUser);
				return new SuccessResult(
						"İş veren sisteme eklendi, kayıt için doğrulama e-postası gönderildi");
			} else {
				return new ErrorResult("Onay işleminiz gerçekleştirilemedi");
			}

		}

	}
}