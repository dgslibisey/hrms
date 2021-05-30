package mernis;

public class MernisService {
	public boolean ValidateByPersonalInfo(long nationalId, String firstName, String lastName, int yearOfBirth) {
		System.out.println(firstName + " " + lastName + " is valid person.");
		return true;
	}
}
