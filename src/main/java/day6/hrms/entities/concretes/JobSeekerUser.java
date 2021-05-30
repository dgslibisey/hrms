package day6.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table (name="jobseeker_users")
@PrimaryKeyJoinColumn(name="user_id")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerUser extends User {
	
	@Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="national_identity")
    private String nationalId;
    
    @Column(name="date_of_birth")
    private Date dateOfBirth;
    
	@Column(name = "is_verified", columnDefinition = "boolean default false")
	private boolean isVerified = false;

	public String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getDateOfBirth() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNationalId() {
		// TODO Auto-generated method stub
		return null;
	}
}
