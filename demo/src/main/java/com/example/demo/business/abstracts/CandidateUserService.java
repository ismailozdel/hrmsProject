package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.CandidateUser;
import com.example.demo.entities.concretes.EmployeeCv;
import com.example.demo.entities.concretes.SchoolList;

public interface CandidateUserService{
	Result add(CandidateUser user);
	DataResult<List<CandidateUser>> getAll();
	DataResult<CandidateUser> getByIdentityNumber(String identityNumber);
	DataResult<EmployeeCv> getEmployeeCv(int id);
	DataResult<SchoolList> getSchoolSort(int id);
}
