package day6.hrms.core.verification;

public interface VerificationService {
	void sendLink(String email);

	String sendCode();
}
