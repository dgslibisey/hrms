package day6.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class City {

	@Id
	@GeneratedValue
	@Column(name = "city_id")
	private int id;
	
	@Column(name = "city_name")
	private String name;
	
	@OneToMany(mappedBy = "city")
	private List<JobAds> jobAds;
}