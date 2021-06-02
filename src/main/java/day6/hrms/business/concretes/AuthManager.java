package day6.hrms.business.concretes;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import day6.hrms.business.abstracts.AuthService;
import day6.hrms.business.abstracts.EmployerUserService;
import day6.hrms.business.abstracts.JobSeekerUserService;
import day6.hrms.business.abstracts.UserService;
import day6.hrms.business.abstracts.VerificationService;
import day6.hrms.core.utilities.adapters.ValidationService;
import day6.hrms.core.utilities.results.ErrorResult;
import day6.hrms.core.utilities.results.Result;
import day6.hrms.core.utilities.results.SuccessResult;
import day6.hrms.core.verification.MailVerificationService;
import day6.hrms.entities.concretes.EmployerUser;
import day6.hrms.entities.concretes.JobSeekerUser;
import day6.hrms.entities.concretes.Verification;

public class AuthManager implements AuthService {

	private UserService userService;
	private EmployerUserService employerUserService;
	private JobSeekerUserService jobSeekerUserService;
	private MailVerificationService mailVerificationService;
	private ValidationService validationService;
	private VerificationService verificationService;


	
	@Autowired
	public AuthManager(UserService userService, EmployerUserService employerUserService, JobSeekerUserService jobSeekerUserService,
			MailVerificationService mailVerificationService, ValidationService validationService, VerificationService verificationService) {
		super();
		this.userService = userService;
		this.employerUserService = employerUserService;
		this.jobSeekerUserService = jobSeekerUserService;
		this.mailVerificationService = mailVerificationService;
		this.validationService = validationService;
		this.verificationService = verificationService;
	}

	public Result registerEmployerUser(EmployerUser employerUser, String confirmPassword) {

		if (!checkIfNullInfoForEmployerUser(employerUser)) {

			return new ErrorResult("Eksik bilgi girişi yaptınız. Lütfen tüm alanları kontrol ediniz.");
		}

		if (!checkIfEqualEmailAndDomain(employerUser.getEmail(), employerUser.getWebSite())) {

			return new ErrorResult("Geçersiz e-posta adresi");
		}

		if (!checkIfEmailExists(employerUser.getEmail())) {

			return new ErrorResult(employerUser.getEmail() + " mail adresi kayıtlı. Başka bir mail adresi ile kayıt oluşturmayı deneyiniz.");
		}

		if (!checkIfEqualPasswordAndConfirmPassword(employerUser.getPassword(), confirmPassword)) {

			return new ErrorResult("Şifreler uyumsuz");
		}

		employerUserService.add(employerUser);
		String code = mailVerificationService.sendCode();
		verificationRecord(code, employerUser.getId(), employerUser.getEmail());
		return new SuccessResult("Registration has been successfully completed");

	}

	@Override
	public Result registerJobSeekerUser(JobSeekerUser jobSeekerUser, String confirmPassword) {

		if (checkIfRealPerson(jobSeekerUser.getNationalId(), jobSeekerUser.getFirstName(),
				jobSeekerUser.getLastName(), jobSeekerUser.getDateOfBirth()) == false) {
			return new ErrorResult("TCKN could not be verified.");
			
		}

		if (!checkIfNullInfoForJobSeekerUser(jobSeekerUser, confirmPassword)) {

			return new ErrorResult("Eksik bilgi girişi yaptınız. Lütfen tüm alanları kontrol ediniz.");
		}

		if (!checkIfExistsTcNo(jobSeekerUser.getNationalId())) {

			return new ErrorResult(jobSeekerUser.getNationalId() + " Bu TC kimlik numarası ile kayıtlı kullanıcı mevcut");
		}

		if (!checkIfEmailExists(jobSeekerUser.getEmail())) {

			return new ErrorResult(jobSeekerUser.getEmail() + " Bu e-posta adresi ile kayıtlı kullanıcı mevcut");
		}

		
		jobSeekerUserService.add(jobSeekerUser);
		String code = mailVerificationService.sendCode();
		verificationRecord(code, jobSeekerUser.getId(), jobSeekerUser.getEmail());
		return new SuccessResult("Registration has been successfully completed");
	}

	// Validation for employer register ---START---

	private boolean checkIfNullInfoForEmployerUser(EmployerUser employerUser) {

		if (employerUser.getCompanyName() != null && employerUser.getWebSite() != null && employerUser.getEmail() != null
				&& employerUser.getPhoneNumber() != null && employerUser.getPassword() != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfEqualEmailAndDomain(String email, String website) {
		String[] emailArr = email.split("@", 2);
		String domain = website.substring(4, website.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}

	// Validation for employer register ---END---

	// Validation for jobseeker register ---START---
	
	private boolean checkIfNullInfoForJobSeekerUser(JobSeekerUser jobSeekerUser, String confirmPassword) {

		if (jobSeekerUser.getFirstName() != null && jobSeekerUser.getLastName() != null && jobSeekerUser.getNationalId() != null
				&& jobSeekerUser.getDateOfBirth() != null && jobSeekerUser.getPassword() != null && jobSeekerUser.getEmail() != null
				&& confirmPassword != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfExistsTcNo(String nationalId) {

		if (this.jobSeekerUserService.findJobSeekerByNationalId(nationalId).getData() == null) {
			return true;
		}
		return false;
	}

	private boolean checkIfRealPerson(String nationalId, String firstName, String lastName, Date date) {

		if (validationService.validateByMernis(nationalId, firstName, lastName, date)) {
			return true;
		}
		return false;
	}

	// Validation for jobseeker register ---END---

	// Common Validation

	private boolean checkIfEmailExists(String email) {

		if (this.userService.findByEmail(email).getData() == null) {

			return true;
		}

		return false;
	}

	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

		if (!password.equals(confirmPassword)) {
			return false;
		}

		return true;
	}
	

	private void verificationRecord(String code, int userId, String email) {

		Verification verification = new Verification(userId, code, false);
		this.verificationService.add(verification);
		System.out.println("Verification code has been sent to " + email );
		
		
	}
}