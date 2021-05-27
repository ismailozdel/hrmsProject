package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.CandidateUserService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.CandidateUser;
@RestController
@RequestMapping("api/candidate")
public class CandidateUserController {
	private CandidateUserService candidateUserService;
	@Autowired
	public CandidateUserController(CandidateUserService candidateUserService) {
		super();
		this.candidateUserService = candidateUserService;
	}
	@GetMapping("/getall")
	public DataResult<List<CandidateUser>> getAll() {
		return this.candidateUserService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody CandidateUser user) {
		return this.candidateUserService.add(user);
	}
	
}
