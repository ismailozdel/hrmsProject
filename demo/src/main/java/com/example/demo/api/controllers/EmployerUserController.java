package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.EmployerUserService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.CandidateUser;
import com.example.demo.entities.concretes.EmployerUser;
import com.example.demo.entities.concretes.Job;

@RestController
@RequestMapping("/api/employer")
public class EmployerUserController {
	private EmployerUserService employerUserService;
	@Autowired
	public EmployerUserController(EmployerUserService employerUserService) {
		super();
		this.employerUserService = employerUserService;
	}
	@GetMapping("/getall")
	public DataResult<List<EmployerUser>> getAll() {
		return this.employerUserService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody EmployerUser user) {
		return this.employerUserService.add(user);
	}
	@PostMapping("/addJobAd")
	public Result addJobAd(@RequestBody Job job) {
		return this.employerUserService.addJobAd(job);
	}
	@PostMapping("/changeJobActivite")
	public Result changeJobActivite(@RequestParam int id) {
		return this.employerUserService.changeJobActivite(id);
	}
	
}
