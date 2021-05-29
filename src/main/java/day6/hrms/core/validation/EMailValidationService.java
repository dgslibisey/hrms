package day6.hrms.core.validation;

import day6.hrms.entities.concretes.User;

public interface EMailValidationService {

	public boolean sendMail(User user);
}
