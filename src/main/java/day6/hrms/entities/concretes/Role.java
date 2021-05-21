package day6.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table (name="roles")
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Role {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	
}
