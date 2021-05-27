package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>{

}
