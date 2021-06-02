package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer>{

}
