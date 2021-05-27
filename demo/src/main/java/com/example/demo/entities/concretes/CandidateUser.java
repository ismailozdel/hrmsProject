package com.example.demo.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode(callSuper=true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidate_users")
public class CandidateUser extends User{
	@Column(name="name")
	private String firstName;
	
	@Column(name="surname")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="birth_year")
	private String birthYear;
}
