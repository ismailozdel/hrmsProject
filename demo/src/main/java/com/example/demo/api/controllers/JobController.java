package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.JobService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.Job;

@RestController
@RequestMapping("/api/job")
public class JobController {
	private JobService jobService;
	
	@Autowired
	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	@GetMapping("/getall")
	public DataResult<List<Job>> getAll() {
		return this.jobService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Job job) {
		return this.jobService.add(job);
	}
	
}
