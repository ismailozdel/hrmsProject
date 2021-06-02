package com.example.demo.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {
	private String companyName;
	private String position;
	private int avaiblePositionNumber;
	private LocalDate releaseDate;
	private LocalDate applicationDeadline;
	
}
