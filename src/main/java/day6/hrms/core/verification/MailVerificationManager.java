package day6.hrms.core.verification;

import java.util.UUID;

public class MailVerificationManager implements MailVerificationService {

	@Override
	public void sendLink(String email) {
		UUID uuid = UUID.randomUUID();
		String verificationLink = "https://hrmsverificationmail/" + uuid.toString();
		System.out.println("Verification link has been sent to " + email);
		System.out.println("Please click on the link to verify your account:  " + verificationLink);
	}

	@Override
	public String sendCode() {
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString();
		System.out.println("Your activation code:  " + verificationCode);
		return verificationCode;
	}

}
