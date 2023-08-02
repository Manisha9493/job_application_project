package com.coforge.job.service;

import com.coforge.job.model.ChangePassword;
import com.coforge.job.model.UserRegistration;

public interface UserService {
	public UserRegistration registerUser(UserRegistration userRegistration);
	public UserRegistration authenticate(String UserName, String password);
	public String changePassword(ChangePassword changePassword);
	public String forgotPassword(String mail);

}
