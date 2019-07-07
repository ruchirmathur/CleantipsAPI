package com.cleantips.iam.user.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class LoginProfile {
	
	private String Password;
	
	private boolean PasswordResetRequired;

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public boolean isPasswordResetRequired() {
		return PasswordResetRequired;
	}

	public void setPasswordResetRequired(boolean passwordResetRequired) {
		PasswordResetRequired = passwordResetRequired;
	} 
	
}
