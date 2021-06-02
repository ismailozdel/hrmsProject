package com.example.demo.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employeeCvs")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateUser"})
public class EmployeeCv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(targetEntity = CandidateUser.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "candidate_id",insertable = false,updatable = false)
	private CandidateUser candidateUser;
	
	private int candidateUserId;
	
	@OneToMany(mappedBy = "employeeCv")
	private List<SchoolList> schoolList;
	
	@OneToMany(mappedBy = "employeeCv")
	private List<Experience> experience;
	
	@OneToMany(mappedBy = "employeeCv")
	private List<Language> language;
	
	@OneToMany(mappedBy = "employeeCv")
	private List<Technologie> technologie;
	
	private String github;
	private String linkedIn;
	private String foreground;
	
}
