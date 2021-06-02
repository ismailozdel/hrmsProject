package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.CandidateUserService;
import com.example.demo.business.abstracts.EmployeeCvService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.CandidateUser;
import com.example.demo.entities.concretes.EmployeeCv;
import com.example.demo.entities.concretes.Experience;
import com.example.demo.entities.concretes.Language;
import com.example.demo.entities.concretes.SchoolList;
@RestController
@RequestMapping("api/candidate")
public class CandidateUserController {
	private CandidateUserService candidateUserService;
	private EmployeeCvService employeeCvService;
	@Autowired
	public CandidateUserController(CandidateUserService candidateUserService, EmployeeCvService employeeCvService) {
		super();
		this.candidateUserService = candidateUserService;
		this.employeeCvService = employeeCvService;
	}
	@GetMapping("/getall")
	public DataResult<List<CandidateUser>> getAll() {
		return this.candidateUserService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody CandidateUser user) {
		return this.candidateUserService.add(user);
	}
	@GetMapping("/getByIdentityNumber")
	public DataResult<CandidateUser> getByIdentityNumber(@RequestParam String identityNumber){
		return this.candidateUserService.getByIdentityNumber(identityNumber);
	}
	@PostMapping("/addCv")
	public Result addCv(@RequestBody EmployeeCv employeeCv) {
		return this.employeeCvService.add(employeeCv);
	}
	@GetMapping("/getEmployeeCv")
	public DataResult<EmployeeCv> getCv(@RequestParam int id){
		return this.candidateUserService.getEmployeeCv(id);
	}
	@PostMapping("/addSchoolInCv")
	public Result addSchoolInCv(@RequestBody SchoolList school) {
		return this.employeeCvService.addSchool(school);
	}
	@PostMapping("/addExperienceInCv")
	public Result addExperienceInCv(@RequestBody Experience experience) {
		return this.employeeCvService.addExperience(experience);
	}
	@PostMapping("/addLanguageInCv")
	public Result addLanguageInCv(@RequestBody Language language) {
		return this.employeeCvService.addLanguage(language);
	}
	@GetMapping("/getSortSchool")
	public DataResult<List<SchoolList>> getSchoolSort (@RequestParam int id){
		return this.employeeCvService.getSchoolSort(id);
	}
	@GetMapping("/getExperienceSort")
	public DataResult<List<Experience>> getExperienceSort(@RequestParam int id){
		return this.employeeCvService.getExperienceSort(id);
	}
	
}
