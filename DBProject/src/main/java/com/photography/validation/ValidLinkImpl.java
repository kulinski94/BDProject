package com.photography.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.photography.utilities.URLReader;

public class ValidLinkImpl implements ConstraintValidator<ValidLink, String> {

	@Override
	public boolean isValid(String link, ConstraintValidatorContext arg1) {
		return URLReader.matchesFlickerAlbumLink(link);
	}

	@Override
	public void initialize(ValidLink arg0) {
		
		
	}

//	@Override
//	public boolean isValid(String email, ConstraintValidatorContext context) {
//		if(email.length() < min) {
//			return false;
//		}
//		
//		if(!EmailValidator.getInstance(false).isValid(email)) {
//			return false;
//		}
//		
//		return true;
//	}

}
