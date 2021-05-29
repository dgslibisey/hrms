package day6.hrms.core.validation;

import org.springframework.stereotype.Service;

import day6.hrms.entities.concretes.User;

@Service
public class EMailValidationManager implements EMailValidationService {

	public boolean sendMail(User user) {
		return true;
	}
}
