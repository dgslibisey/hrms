package mernis;

import java.util.Date;

public class MernisService {
	public boolean ValidateByPersonalInfo(String nationalId, String firstName, String lastName, Date dateOfBirth) {
		System.out.println(firstName + " " + lastName + " için mernis doğrulaması gerçekleştirildi.");
		return true;
	}
}
