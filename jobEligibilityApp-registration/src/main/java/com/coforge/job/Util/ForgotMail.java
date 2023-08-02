package com.coforge.job.Util;

import javax.mail.MessagingException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

public class ForgotMail {
	@Autowired
	MimeMessage mimeMessage;
	
	public void forgotMail(String to, String subject, String password) throws MessagingException
	{
	}

}
