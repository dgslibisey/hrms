package day6.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table (name = "users")
@NoArgsConstructor
@AllArgsConstructor

public class User {

		@Id
		@GeneratedValue
		@Column(name = "id")
		private int id;
		
		@Column(name="email")
		private String email;
		
		@Column(name="password")
		private String password;
		
		@Column(name="created_date")
		private Date createdDate;

	
	
}
