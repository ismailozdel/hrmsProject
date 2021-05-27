package com.example.demo.business.concretes;

import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.StaffUserService;
import com.example.demo.entities.concretes.EmployerUser;
@Service
public class StaffUserManager implements StaffUserService{
	public static boolean confirmEmployer(EmployerUser user) {
		return true;
	}
	
}
