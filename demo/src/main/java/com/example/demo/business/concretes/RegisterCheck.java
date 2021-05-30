package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.core.adapter.MernisAdapter;
import com.example.demo.core.adapter.MernisService;
import com.example.demo.core.utilities.results.ErrorResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.CandidateUserDao;
import com.example.demo.dataAccess.abstracts.EmployerUserDao;
import com.example.demo.dataAccess.abstracts.UserDao;
import com.example.demo.entities.concretes.CandidateUser;
import com.example.demo.entities.concretes.EmployerUser;
import com.example.demo.entities.concretes.StaffUser;
import com.example.demo.entities.concretes.User;
@Component
public class RegisterCheck {
	
	private CandidateUserDao candidateUserDao;
	@SuppressWarnings("unused")
	private EmployerUserDao employerUserDao;
	private UserDao userDao;

	
	@Autowired
	public RegisterCheck(UserDao userDao, CandidateUserDao candidateUserDao, EmployerUserDao employerUserDao) {
		super();
		this.candidateUserDao = candidateUserDao;
		this.employerUserDao = employerUserDao;
		this.userDao = userDao;
	}


	public boolean RegisterCheckAllFieldsRequired(CandidateUser user) {
		if(!(user.getEmail() != null && user.getPassword() !=null && user.getFirstName() != null
				&& user.getLastName() != null && user.getIdentityNumber()  != null &&
				user.getBirthYear() != null)) {
			return false;
		}
		return true;
	}
	
	
	public boolean RegisterCheckAllFieldsRequired(EmployerUser user) {
		if(user.getEmail() != null && user.getPassword() !=null && user.getCompanyName() != null
				&& user.getPhoneNumber() != null && user.getWebAddress() != null) {
			new SuccessResult();
			return true;
		}
		new ErrorResult("Lütfen bilgileriniz eksiksiz girin.");
		return false;
		
	}
	public boolean RegisterCheckAllFieldsRequired(StaffUser user) {
		if(user.getEmail() != null && user.getPassword() !=null && user.getFirstName() != null && user.getLastName() != null) {
			new SuccessResult();
			return true;
		}
		new ErrorResult("Lütfen bilgileriniz eksiksiz girin.");
		return false;
		
	}
	
	
	public boolean MernisCheck(CandidateUser user) {
		MernisService mernisAdapter = new MernisAdapter();
		return mernisAdapter.mernisCheckService(user);
		}

	
	/*private Result checkIfUserExist(CandidateUser user) {
		
		List<CandidateUser> candidateUser = this.candidateUserDao.findAll();
		for (CandidateUser candidateUser2 : candidateUser) {
			
			if(candidateUser2.getEmail().equals(user.getEmail())) {
				return new ErrorResult("Bu mail adresi mevcut.");
			}
			
			if(candidateUser2.getIdentityNumber().equals(user.getIdentityNumber())) {
				return new ErrorResult("Bu kimlik numarası mevcut.");
			}
		}
		
		return null;
	}*/
//	public boolean isEmailUsedCheck(CandidateUser user) {
//		List<CandidateUser> candidateUser = this.candidateUserDao.findAll();
//		for (CandidateUser candidateUser2 : candidateUser) {
//			if(candidateUser2.getEmail().equals(user.getEmail())) {
//				return false;
//			}
//		}
//		return true;
//	}
//	public boolean isIdentityNumberUsedCheck(CandidateUser user) {
//		List<CandidateUser> candidateUser = this.candidateUserDao.findAll();
//		for (CandidateUser candidateUser2 : candidateUser) {
//			if(candidateUser2.getIdentityNumber().equals(user.getIdentityNumber())) {
//				return false;
//			}
//		}
//		return true;
//	}
	public boolean isIdentityNumberUsedCheck(CandidateUser user) {
		if(this.candidateUserDao.getByIdentityNumber(user.getIdentityNumber())!=null) {
			return false;
		}
		return true;
	}
	
	public boolean isEmailUsedCheck(User user) {
		if(this.userDao.getByEmail(user.getEmail())!=null) {
			return false;
		}
		return true;
	}
	
	
	
	public boolean isEmailDomainCheck(EmployerUser user) {
		String emailSplit = user.getEmail().split("@")[1];
		String domainSplit = user.getWebAddress().split("www.")[1];
		if(domainSplit.equals(emailSplit)) {
			return true;
		}
		return false;
	}
	public boolean isEmailUsedCheck(EmployerUser user) {
		List<EmployerUser> employerUser = this.employerUserDao.findAll();
		for (EmployerUser employerUser2 : employerUser) {
			if(employerUser2.getEmail().equals(user.getEmail())) {
				return false;
			}
		}
		return true;
	}

	/*	public boolean RegisterCheckAllFieldsRequired(CandidateUser user) {
		if(!(user.getEmail() != null && user.getPassword() !=null && user.getFirstName() != null
				&& user.getLastName() != null && user.getIdentityNumber()  != null &&
				user.getBirthYear() != null)) {
			new ErrorResult("Lütfen bilgileriniz eksiksiz girin.");
			return false;
		}
		if(MernisCheck(user)==false) {
			new ErrorResult("Lütfen bilgilerinizin doğruluğunu kontrol edin.");
			return false;
		}
		if(checkIfUserExist(user) != null) {
			return false;
		}
		new SuccessResult();
		return true;
	} 
	*/







}
