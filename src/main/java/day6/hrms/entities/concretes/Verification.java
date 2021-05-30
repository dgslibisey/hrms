package day6.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="verification")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Verification {


	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="verify_code")
	private String code;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	public Verification(int userId, String code, boolean isConfirmed) {
		super();
		this.userId = userId;
		this.code = code;
		this.isConfirmed = isConfirmed;

	}
	
}
