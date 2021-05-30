package com.example.demo.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_positions")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="position")
	private String position;
	
	@Column(name="description")
	private String description;
	@Column(name="location")
	private String location;
	@Column(name="salary_rate_max")
	private int salaryRateMax;
	@Column(name="salary_rate_min")
	private int salaryRateMin;
	@Column(name="avaible_number")
	private int avaibleNumber;
	@Column(name="application_deadline")
	private LocalDate applicationDeadlinee;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private EmployerUser employerId;
	
	@Column(name="release_date")
	private LocalDate releaseDate = LocalDate.now();
	
	@Column(name="is_activated")
	private boolean isActivated = true;
	
}
