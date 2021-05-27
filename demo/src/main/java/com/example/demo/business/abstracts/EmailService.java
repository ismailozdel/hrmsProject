package com.example.demo.business.abstracts;

import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.User;

public interface EmailService {
	public Result sendEmail(User user);
}
