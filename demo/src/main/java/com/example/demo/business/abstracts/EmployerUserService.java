package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.EmployerUser;
import com.example.demo.entities.concretes.Job;

public interface EmployerUserService {
	Result add(EmployerUser user);
	DataResult<List<EmployerUser>> getAll();
	Result addJobAd(Job job);
	Result changeJobActivite(int id);
}
