package day6.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_ads")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobAds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="job_id")
	private int id;
    
    @Column(name="job_name")
	private String jobName;
    
    @Column(name="job_definition")
	private String jobDefinition;
    
	@Column(name = "salary_min")
	private int salaryMin;
	
	@Column(name = "salary_max")
	private int salaryMax;
    
    @Column(name="open_position")
	private int openPosition;
    
    @Column(name="application_deadline")
	private Date deadline;
    
    @Column(name="employer_id")
	private int employerId;
    
    @Column(name="is_activated")
	private boolean isActivated;
    
	@Column(name = "is_open")
	private boolean isOpen;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private JobPosition jobPosition;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private EmployerUser employerUser;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
}
