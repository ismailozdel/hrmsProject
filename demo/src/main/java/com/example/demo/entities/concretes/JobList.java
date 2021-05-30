package com.example.demo.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobList {
	private String companyName;
	private String position;
	private int avaiblePositionNumber;
	private LocalDate releaseDate;
	private LocalDate applicationDeadline;
	
}
