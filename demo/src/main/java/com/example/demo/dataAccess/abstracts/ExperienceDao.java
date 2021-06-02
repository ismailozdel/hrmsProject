package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.Experience;
import com.example.demo.entities.concretes.SchoolList;

public interface ExperienceDao extends JpaRepository<Experience, Integer>{

	List<Experience> getByEmployeeCv_IdOrderByEndDateDesc(int id);

}
