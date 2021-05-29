package day6.hrms.core.validation;

import org.springframework.stereotype.Service;

import day6.hrms.entities.concretes.User;

@Service
public class MernisValidationManager implements MernisValidationService {

	public boolean IsMernisValidated(User user) {
		return true;

	}
}