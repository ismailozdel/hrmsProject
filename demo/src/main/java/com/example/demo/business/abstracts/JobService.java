package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.entities.concretes.Job;
import com.example.demo.entities.concretes.JobList;

public interface JobService {
	SuccessDataResult<List<JobList>> getAll();
	Result add(Job job);
	DataResult<List<JobList>> getByIsActivated();
	DataResult<List<JobList>> findByIsActivatedOrderByReleaseDateDesc();
	DataResult<List<JobList>> getByEmployerId(int id);
}
