package com.coforge.jobs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.coforge.jobs.binding.AppliedJobs;
import com.coforge.jobs.entities.JobApplication;
import com.coforge.jobs.entities.User;
import com.coforge.jobs.service.JobApplicationService;
import com.coforge.jobs.util.JobExceptions;

import jakarta.validation.ValidationException;

@RestController
@CrossOrigin
public class JobController {

	@Autowired
	public JobApplicationService jobApplicationService;

	
	@PostMapping("/applyjob")
	public ResponseEntity<User> applyJob(@RequestBody User user) throws JobExceptions {
		User saveJobApplication = new User();
		System.out.println("User Object============================================" +user.toString());
		Long userId=null;
		
			saveJobApplication= jobApplicationService.saveJobApplication(user);
		
	
		return new ResponseEntity<User>(saveJobApplication, HttpStatus.OK);

	}
	
	@GetMapping("/get-applied-jobs/{userId}")
	public ResponseEntity<List<AppliedJobs>> getAppliedJobs(@PathVariable("userId") Long userId) throws JobExceptions
	{
		List<AppliedJobs> appliedJobs=new ArrayList<>();
		try {
			appliedJobs=jobApplicationService.getAppliedJobs(userId);
			
		}catch(Exception e)
		{
			throw new JobExceptions("failed for fetching applied jobs");
		}
		return new ResponseEntity<List<AppliedJobs>>(appliedJobs,HttpStatus.OK);
	}
	
	@PutMapping("/update-jobs")
    public ResponseEntity<String> updateJobs(@RequestBody User user)
    {
    	boolean status=jobApplicationService.updateJobsApplication(user);
    	if(status)
    	{
    		return new ResponseEntity<String>("job updated Successfully",HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<String>("Failed to update job",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
	
	
	@DeleteMapping("/delete-jobs/{jobId}")
	public ResponseEntity<String> deleteJobs(@PathVariable("jobId") Long jobId) throws JobExceptions
	{
		boolean status=jobApplicationService.deleteJobApplication(jobId);
		try {
    	if(status)
    	{
    		return new ResponseEntity<String>("job deleted Successfully",HttpStatus.OK);
    	}
		}catch(Exception e)
    	{
    		throw new JobExceptions("failed to delete Job");
    	}
		return new ResponseEntity<String>("Failed to delete job",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getUsers() throws JobExceptions
	{   List<User> users=new ArrayList<>();
		try {
			users=jobApplicationService.getAllUsers();
			return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		}catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Long id)
	{
		User user=new User();
		user=jobApplicationService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
