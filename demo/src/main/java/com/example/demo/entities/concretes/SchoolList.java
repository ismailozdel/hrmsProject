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
@Table(name="Schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employeeCv"})
public class SchoolList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="school_id")
	@NotBlank
	@NotNull
	private int id;
	
	@Column(name="school_name")
	@NotBlank
	@NotNull
	private String name;
	
	@Nullable
	@Column(name="graduationYear")
	private LocalDate graduationYear;
	
	@Column(name="entryYear")
	@NotBlank
	@NotNull
	private LocalDate entryYear;
	
	@ManyToOne(targetEntity = EmployeeCv.class , fetch = FetchType.EAGER)
	@JoinColumn(name="employee_Cv_Id",insertable = false,updatable = false)
	private EmployeeCv employeeCv;
	
	@Column(name="employee_Cv_Id")
	private int employeeCvId;
}
