package com.example.demo.entities.concretes;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers_users")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job"})
public class EmployerUser extends User{
	@Id
	@Column(name="id")
	private int id;
	
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_address")
	private String webAddress;
	
	@Column(name="phone")
	private String phoneNumber;
	
	@OneToMany(mappedBy="employerId")
	private List<Job> job;
}
