package day6.hrms.core.verification;

public interface MailVerificationService {
	void sendLink(String email);
	String sendCode();
}
