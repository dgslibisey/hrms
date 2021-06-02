package mernis;

public class MernisService {
	public boolean ValidateByPersonalInfo(String nationalId, String firstName, String lastName, int dateOfBirth) {
		System.out.println(firstName + " " + lastName + " için mernis doğrulaması gerçekleştirildi.");
		return true;
	}
}
