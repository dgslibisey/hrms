package day6.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import day6.hrms.entities.concretes.Verification;

public interface VerificationDao extends JpaRepository<Verification, Integer>{

	Verification getByUserId(int userId);

}
