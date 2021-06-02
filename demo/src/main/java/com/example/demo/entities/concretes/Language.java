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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="language")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employeeCv"})
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="language_id")
	private int id;
	
	@Column(name="language_name")
	@NotBlank
	@NotNull
	private String languageName;
	
	@Column(name="language_level")
	@NotBlank
	@NotNull
	private int languageLevel;
	
	@ManyToOne(targetEntity = EmployeeCv.class , fetch = FetchType.EAGER)
	@JoinColumn(name="employee_Cv_Id",insertable = false,updatable = false)
	private EmployeeCv employeeCv;
	
	@Column(name="employee_Cv_Id")
	private int employeeCvId;
}
