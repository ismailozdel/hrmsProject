package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.Technologie;

public interface TechnologieDao extends JpaRepository<Technologie, Integer>{

}
