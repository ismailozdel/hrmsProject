package com.example.demo.core.adapter;

import com.example.demo.entities.concretes.CandidateUser;
import com.example.demo.micro.mernis.MernisCheck;

public class MernisAdapter implements MernisService{
	

	@Override
	public boolean mernisCheckService(CandidateUser user) {
		MernisCheck mernisCheck = new MernisCheck();
		return mernisCheck.check(user.getFirstName(), user.getLastName(), user.getBirthYear(), user.getIdentityNumber());
	}
	
}
