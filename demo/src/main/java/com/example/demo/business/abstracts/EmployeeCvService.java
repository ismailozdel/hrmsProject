package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.EmployeeCv;
import com.example.demo.entities.concretes.Experience;
import com.example.demo.entities.concretes.Language;
import com.example.demo.entities.concretes.SchoolList;

public interface EmployeeCvService {
	Result add(EmployeeCv employeeCv);
	Result addSchool(SchoolList school);
	Result addExperience(Experience experience);
	Result addLanguage(Language language);
	DataResult<List<SchoolList>> getSchoolSort(int id);
	DataResult<List<Experience>> getExperienceSort(int id);
}
