package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.EmployerUser;

public interface EmployerUserDao extends JpaRepository<EmployerUser, Integer>{

}
