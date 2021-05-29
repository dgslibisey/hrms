package day6.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table (name="jobseeker_users")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerUser extends User {
	
	@Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="national_identity")
    private String nationalIdentity;
    
    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

	public Object getPasswordRepeat() {
		// TODO Auto-generated method stub
		return null;
	}

}
