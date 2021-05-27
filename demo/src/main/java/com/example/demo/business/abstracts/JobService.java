package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.Job;

public interface JobService {
	DataResult<List<Job>> getAll();
	Result add(Job job);
}
