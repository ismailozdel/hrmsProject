package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.EmployeeCv;

public interface EmployeeCvDao extends JpaRepository<EmployeeCv, Integer>{
	EmployeeCv getByCandidateUser_Id(int id);
}
