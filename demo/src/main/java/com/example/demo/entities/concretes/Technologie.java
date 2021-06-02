package com.example.demo.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="technologies")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employeeCv"})

public class Technologie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="programming_language_name")
	private String programmingLanguageName;
	@Column(name="programming_technology_name")
	private String programmingTechnologyName;
	
	@ManyToOne(targetEntity = EmployeeCv.class , fetch = FetchType.EAGER)
	@JoinColumn(name="employee_Cv_Id",insertable = false,updatable = false)
	private EmployeeCv employeeCv;
	
	@Column(name="employee_Cv_Id")
	private int employeeCvId;
}
