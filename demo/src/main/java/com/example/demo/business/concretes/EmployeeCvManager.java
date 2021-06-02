package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.EmployeeCvService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.EmployeeCvDao;
import com.example.demo.dataAccess.abstracts.ExperienceDao;
import com.example.demo.dataAccess.abstracts.LanguageDao;
import com.example.demo.dataAccess.abstracts.SchoolListDao;
import com.example.demo.dataAccess.abstracts.TechnologieDao;
import com.example.demo.entities.concretes.EmployeeCv;
import com.example.demo.entities.concretes.Experience;
import com.example.demo.entities.concretes.Language;
import com.example.demo.entities.concretes.SchoolList;
@Service
public class EmployeeCvManager implements EmployeeCvService{
	private EmployeeCvDao employeeCvDao;
	private SchoolListDao schoolListDao;
	private ExperienceDao experienceDao;
	private LanguageDao languageDao;
	private TechnologieDao technologieDao;
	
	@Autowired
	public EmployeeCvManager(EmployeeCvDao employeeCvDao, SchoolListDao schoolListDao, ExperienceDao experienceDao,
			LanguageDao languageDao,TechnologieDao technologieDao) {
		super();
		this.employeeCvDao = employeeCvDao;
		this.schoolListDao = schoolListDao;
		this.experienceDao = experienceDao;
		this.languageDao = languageDao;
		this.technologieDao = technologieDao;
	}

	@Override
	public Result add(EmployeeCv employeeCv) {
		this.schoolListDao.saveAll(employeeCv.getSchoolList());
		this.experienceDao.saveAll(employeeCv.getExperience());
		this.languageDao.saveAll(employeeCv.getLanguage());
		this.technologieDao.saveAll(employeeCv.getTechnologie());
		this.employeeCvDao.save(employeeCv);
		return new SuccessResult("Eklendi");
	}

	@Override
	public Result addSchool(SchoolList school) {
		this.schoolListDao.save(school);
		return new SuccessResult("Eklendi");
	}

	@Override
	public Result addExperience(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("Eklendi");
	}

	@Override
	public Result addLanguage(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<SchoolList>> getSchoolSort(int id) {
		int i = this.employeeCvDao.getByCandidateUser_Id(id).getId();
		
		return new SuccessDataResult<List<SchoolList>>(this.schoolListDao.getByEmployeeCv_IdOrderByGraduationYearDesc(i));
	}

	@Override
	public DataResult<List<Experience>> getExperienceSort(int id) {
		int i = this.employeeCvDao.getByCandidateUser_Id(id).getId();
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getByEmployeeCv_IdOrderByEndDateDesc(i));
	}
	
	
}
