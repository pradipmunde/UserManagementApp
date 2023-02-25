package com.pradip.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="User_Details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Long phNo;
	
	private String dob;
	
	private String gender;
	
	private String country;
	
	private String State;
	
	private String city;
	
	private String password;

	


	
	
	

}
