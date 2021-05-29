package day6.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name="employer_users")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor

public class EmployerUser extends User {

	@Column(name= "company_name")
	private String companyName;
	
	@Column(name= "web_site")
	private String webSite;
	
	@Column(name="phone_number")
	private String phoneNumber;

	public Object getPasswordRepeat() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
