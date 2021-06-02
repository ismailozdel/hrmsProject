package com.example.demo.entities.concretes;

import java.time.LocalDate;
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

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employeeCv"})
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="experience_id")
	private int id;
	
	@Column(name="company_name")
	@NotBlank
	@NotNull
	private String companyName;
	
	@Column(name="position")
	@NotBlank
	@NotNull
	private String position;
	
	@Column(name="start_date")
	@NotBlank
	@NotNull
	private LocalDate startDate;
	
	@Column(name="end_date")
	@Nullable
	private LocalDate endDate;
	
	@ManyToOne(targetEntity = EmployeeCv.class , fetch = FetchType.EAGER)
	@JoinColumn(name="employee_Cv_Id",insertable = false,updatable = false)
	private EmployeeCv employeeCv;
	
	@Column(name="employee_Cv_Id")
	private int employeeCvId;
}
