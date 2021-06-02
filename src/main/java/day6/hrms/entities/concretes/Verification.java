package day6.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="verification")
@NoArgsConstructor
@AllArgsConstructor
public class Verification {


//	@Id
//	@GeneratedValue
//	@Column(name="id")
//	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="verify_code")
	private String verifyCode;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
}
