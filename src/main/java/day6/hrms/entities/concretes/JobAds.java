package day6.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @Column(name="job_city")
	private String jobCity;
    
    @Column(name="salary")
	private int salary;
    
    @Column(name="open_position")
	private int openPosition;
    
    @Column(name="application_deadline")
	private Date deadline;
    
    @Column(name="employer_id")
	private int employerId;
    
    @Column(name="is_activated")
	private boolean isActivated;
	
}
