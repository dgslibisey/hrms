package day6.hrms.core.utilities.adapters;

import mernis.MernisService;

public class MernisServiceAdapter implements ValidationService {

	@Override
	public boolean validateByMernis(long nationalId, String firstName, String lastName, int yearOfBirth) {

		MernisService client = new MernisService();

		boolean result = true;
		try {
			result = client.ValidateByPersonalInfo(nationalId, firstName, lastName, yearOfBirth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

}