package com.example.demo.business.concretes;

import com.example.demo.business.abstracts.EmailService;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.entities.concretes.User;

public class EmailManager implements EmailService{

	@Override
	public Result sendEmail(User user) {
		// TODO Auto-generated method stub
		return new SuccessResult(user.getEmail()+"email gönderildi.");
	}

}
