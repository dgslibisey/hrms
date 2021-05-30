package day6.hrms.business.concretes;

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
import day6.hrms.entities.concretes.EmployerUser;
import day6.hrms.entities.concretes.JobSeekerUser;

public class AuthManager implements AuthService {

	private UserService userService;
	private EmployerUserService employerService;
	private JobSeekerUserService jobseekerService;
	private VerificationService verificationService;
	private ValidationService validationService;
	private Object jobSeekerUserService;
	private EmployerUserService employerUserService;

	
	@Autowired
	public AuthManager(UserService userService, EmployerUserService employerUserService, JobSeekerUserService jobseekerUserService,
			VerificationService verificationService, ValidationService validationService,
			VerificationService verificationCodeService) {
		super();
		this.userService = userService;
		this.employerUserService = employerUserService;
		this.jobSeekerUserService = jobseekerUserService;
		this.verificationService = verificationService;
		this.validationService = validationService;
	}

	public Result registerEmployerUser(EmployerUser employerUser, String confirmPassword) {

		if (!checkIfNullInfoForEmployer(employerUser)) {

			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}

		if (!checkIfEqualEmailAndDomain(employerUser.getEmail(), employerUser.getWebSite())) {

			return new ErrorResult("Invalid email address.");
		}

		if (!checkIfEmailExists(employerUser.getEmail())) {

			return new ErrorResult(employerUser.getEmail() + " already exists.");
		}

		if (!checkIfEqualPasswordAndConfirmPassword(employerUser.getPassword(), confirmPassword)) {

			return new ErrorResult("Passwords do not match.");
		}

		Result add = employerService.add(employerUser);
		String code = verificationService.sendCode();
		return new SuccessResult("Registration has been successfully completed");

	}

	@Override
	public Result registerJobSeekerUser(JobSeekerUser jobSeekerUser, String confirmPassword) {

		if (checkIfRealPerson(Long.parseLong(jobSeekerUser.getNationalId()), jobSeekerUser.getFirstName(),
				jobSeekerUser.getLastName(), jobSeekerUser.getDateOfBirth().getYear() == false) {
			return new ErrorResult("TCKN could not be verified.");
		}

		if (!checkIfNullInfoForJobseeker(jobSeekerUser, confirmPassword)) {

			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}

		if (!checkIfExistsTcNo(jobSeekerUser.getNationalId())) {

			return new ErrorResult(jobSeekerUser.getNationalId() + " already exists.");
		}

		if (!checkIfEmailExists(jobSeekerUser.getEmail())) {

			return new ErrorResult(jobSeekerUser.getEmail() + " already exists.");
		}

		
		jobseekerService.add(jobSeekerUser);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, jobSeekerUser.getId(), jobSeekerUser.getEmail());
		return new SuccessResult("Registration has been successfully completed");
	}

	// Validation for employer register ---START---

	private boolean checkIfNullInfoForEmployer(EmployerUser employerUser) {

		if (employerUser.getCompanyName() != null && employerUser.getWebsite() != null && employerUser.getEmail() != null
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

	
	private boolean checkIfNullInfoForJobseeker(JobSeekerUser jobSeekerUser, String confirmPassword) {

		if (jobSeekerUser.getFirstName() != null && jobSeekerUser.getLastName() != null && jobSeekerUser.getNationalId() != null
				&& jobSeekerUser.getDateOfBirth() != null && jobSeekerUser.getPassword() != null && jobSeekerUser.getEmail() != null
				&& confirmPassword != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfExistsTcNo(String nationalId) {

		if (((JobSeekerUserService) this.jobSeekerUserService).getJobseekerByNationalId(nationalId).getData() == null) {
			return true;
		}
		return false;
	}

	private boolean checkIfRealPerson(long nationalId, String firstName, String lastName, int yearOfBirth) {

		if (validationService.validateByMernis(nationalId, firstName, lastName, yearOfBirth)) {
			return true;
		}
		return false;
	}

	private boolean checkIfEmailExists(String email) {

		if (this.userService.getUserByEmail(email).getData() == null) {

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

	@Override
	public Result registerJobSeekerUser(JobSeekerUser jobseekerUsers, String confirmPassword) {
		// TODO Auto-generated method stub
		return null;
	}
}