package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.EmployerUserService;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.ErrorResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.EmployerUserDao;
import com.example.demo.entities.concretes.EmployerUser;
@Service
public class EmployerUserManager implements EmployerUserService{
	private EmployerUserDao employerUserDao;
	private RegisterCheck registerCheck;
	@Autowired
	public EmployerUserManager(EmployerUserDao employerUserDao,RegisterCheck registerCheck) {
		super();
		this.employerUserDao = employerUserDao;
		this.registerCheck = registerCheck;
	}

	@Override
	public Result add(EmployerUser user) {
		if(this.registerCheck.RegisterCheckAllFieldsRequired(user) != true) {	
			return new ErrorResult("Lütfen bilgileri eksiksiz giriniz.");
		}
		if(this.registerCheck.isEmailDomainCheck(user) != true) {
			return new ErrorResult("Lütfen web adresiniz ile aynı domaine sahip bir mail adresi giriniz.");
		}
		if(this.registerCheck.isEmailUsedCheck(user) != true) {
			return new ErrorResult("Bu mail adresi sistemde kayıtlı.");
		}
		if(StaffUserManager.confirmEmployer(user) != true) {
			
		}
		this.employerUserDao.save(user);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<EmployerUser>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<EmployerUser>>(this.employerUserDao.findAll(),"Listelendi");
	}

}
