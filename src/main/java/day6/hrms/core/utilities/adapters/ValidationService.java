package day6.hrms.core.utilities.adapters;

import java.util.Date;

public interface ValidationService {
	boolean validateByMernis(String nationalId, String firstName, String lastName, Date dateOfBirth);
}
