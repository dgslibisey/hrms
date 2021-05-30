package day6.hrms.business.abstracts;

import day6.hrms.core.utilities.results.Result;
import day6.hrms.entities.concretes.Verification;

public interface VerificationService {

	Result add(Verification code);

	String sendCode();
}
