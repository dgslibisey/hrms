package day6.hrms.core.validation;

import org.springframework.stereotype.Service;

import day6.hrms.entities.concretes.User;

@Service
public class StaffValidationManager implements StaffValidationService {
	
	public boolean staffValidated(User user) {
		return true;
	}

}
