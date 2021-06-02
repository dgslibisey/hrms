package day6.hrms.core.utilities.adapters;

import java.util.Date;

import mernis.MernisService;

public class MernisServiceAdapter implements ValidationService {

	@Override
	public boolean validateByMernis(String nationalId, String firstName, String lastName, Date dateOfBirth) {

		MernisService client = new MernisService();

		boolean result = true;
		try {
			result = client.ValidateByPersonalInfo(nationalId, firstName, lastName, dateOfBirth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

}