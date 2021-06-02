package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.SchoolList;

public interface SchoolListDao extends JpaRepository<SchoolList, Integer>{
	List<SchoolList> getByEmployeeCv_IdOrderByGraduationYearDesc(int id);
}
