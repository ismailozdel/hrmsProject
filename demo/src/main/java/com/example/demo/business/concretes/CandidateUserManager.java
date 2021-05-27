package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.CandidateUserService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.ErrorResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.CandidateUserDao;
import com.example.demo.entities.concretes.CandidateUser;
@Service
public class CandidateUserManager implements CandidateUserService{
	private CandidateUserDao userDao;
	private RegisterCheck registerCheck;
	@Autowired
	public CandidateUserManager(CandidateUserDao userDao, RegisterCheck registerCheck) {
		super();
		this.userDao = userDao;
		this.registerCheck = registerCheck;
	}
	@Override
	public Result add(CandidateUser user) {
		if(this.registerCheck.RegisterCheckAllFieldsRequired(user) != true) {
			return new ErrorResult("Lütfen tüm alanları doldurun");
		}
		if(this.registerCheck.MernisCheck(user)!= true) {
			return new ErrorResult("Kullanıcı bilgileri doğru değil. Lütfen kontrol ediniz");
		}
		if(this.registerCheck.isEmailUsedCheck(user)!=true) {
			return new ErrorResult("Bu mail adresi sistemde kayıtlı.");
		}
		if(this.registerCheck.isIdentityNumberUsedCheck(user)!=true) {
			return new ErrorResult("Bu kimlik numarı sistemde kayıtlı.");
		}
		
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı kayıt edildi");
	}
	@Override
	public DataResult<List<CandidateUser>> getAll() {
		
		return new SuccessDataResult<List<CandidateUser>>(this.userDao.findAll(),"Listelendi");
	}

}
