package com.example.demo.entities.concretes;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employeeCv"})

public class CandidateUser extends User{
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String firstName;
	
	@Column(name="surname")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="birth_year")
	private String birthYear;
	
	@OneToOne(mappedBy = "candidateUser")
	private EmployeeCv employeeCv;
}
