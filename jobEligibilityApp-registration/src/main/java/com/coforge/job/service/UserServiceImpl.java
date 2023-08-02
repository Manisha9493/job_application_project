package com.coforge.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.job.model.ChangePassword;
import com.coforge.job.model.UserRegistration;
import com.coforge.job.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	 UserRepository userRepo;
	
	
	@Override
	public UserRegistration authenticate(String userName, String password)
	{
		return userRepo.findByUserNameAndPassword(userName, password).orElse(null);
	}

	@Override
	public UserRegistration registerUser(UserRegistration userRegistration) {
		// TODO Auto-generated method stub
		if(userRegistration.getUserName()!=null && userRegistration.getPassword()!=null &&userRegistration.getEmail()!=null)
		{
			return userRepo.save(userRegistration);
		}else
		{
			return null;
		}
		
	}

	@Override
	public String changePassword(ChangePassword changePassword) {
	try {	
	UserRegistration userRegistration=userRepo.findByEmail(changePassword.getEmail());
	if(userRegistration!=null)
	{
		if(userRegistration.getPassword().equals(changePassword.getOldPassword()))
		{
			userRegistration.setPassword(changePassword.getNewPassword());
			userRepo.save(userRegistration);
			return "password updated successfully";
		}else
		{
			return "password mismatch with old password";
		}
		
	}else
	{
		return "user doesn't exist";
	}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return null;	
	}
	
	
	
	public String forgotPassword(String mail)
	{
		try
		{
			UserRegistration userRegistration=userRepo.findByEmail(mail);
			if(!userRegistration.equals(null) && !userRegistration.getEmail().equals(null))
			{
				return "check you email for credentials";
			}
		}catch(Exception e)
		{
			
		}
		return mail;
	}
	

}
