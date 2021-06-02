package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.JobService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.entities.concretes.Job;
import com.example.demo.entities.concretes.JobList;
import com.example.demo.entities.dtos.JobDto;

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
	public SuccessDataResult<List<JobList>> getAll() {
		return this.jobService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Job job) {
		return this.jobService.add(job);
	}
	@GetMapping("/getActive")
	public DataResult<List<JobList>> getByIsActivated(){
		return this.jobService.getByIsActivated();
	}
	@GetMapping("/getActiveSort")
	public DataResult<List<JobList>> findByIsActivatedOrderByReleaseDateDesc(){
		return this.jobService.findByIsActivatedOrderByReleaseDateDesc();
	}
	@GetMapping("/getByEmployerId")
	public DataResult<List<JobList>> getByEmployerId(@RequestParam int id){
		return this.jobService.getByEmployerId(id);
	}

}
