package com.example.demo.micro.mernis;

public class MernisCheck {
	public boolean check(String firstName, String lastName, String birthDate, String nationalIdentity) {
		if(firstName.length()>=2 && lastName.length()>=2 && Integer.valueOf(birthDate) > 1900 && nationalIdentity.length()==11) {
			return true;
		}
		return false;
	}
}
