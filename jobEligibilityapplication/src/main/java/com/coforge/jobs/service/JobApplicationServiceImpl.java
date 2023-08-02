package com.coforge.jobs.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.jobs.binding.AppliedJobs;
import com.coforge.jobs.binding.JobDetails;
import com.coforge.jobs.entities.JobApplication;
import com.coforge.jobs.entities.User;
import com.coforge.jobs.repository.JobRepository;
import com.coforge.jobs.repository.UserRepository;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {
	@Autowired
	JobRepository jobRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public User saveJobApplication(User user) {
		User user1 = new User();
		 User existingUser = userRepository.findById(user.getUserId()).orElse(null);
		if (existingUser == null) {
	        // If the user does not exist, save the new user with the job application
	        return userRepository.save(user);
	    } else {
	        // If the user exists, add the new job applications to the existing list
	        List<JobApplication> existingApplications = existingUser.getJobApplications();
	        List<JobApplication> newApplications = user.getJobApplications();

	        if (existingApplications == null) {
	            existingApplications = new ArrayList<>();
	        }

	        if (newApplications != null && !newApplications.isEmpty()) {
	            existingApplications.addAll(newApplications);
	        }

	        existingUser.setJobApplications(existingApplications);
	        return userRepository.save(existingUser);
	    }
	}
	

	
	@Override
	public List<AppliedJobs> getAppliedJobs(Long userId) {
	    User userApplications = userRepository.getById(userId);
	    List<AppliedJobs> appliedJobs = new ArrayList<>();
	    
	    if (userApplications != null) {
	    	
	        List<JobApplication> jobApplications = userApplications.getJobApplications();
	        for (JobApplication jobApplication : jobApplications) {
	            AppliedJobs appliedJob = new AppliedJobs();
	            appliedJob.setUserId(userApplications.getUserId());
	            
	            // Initialize the JobDetails properly before setting values
	            //appliedJob.setJobDetails(new JobDetails()); // Assuming JobDetails has a default constructor
	            appliedJob.setJobId(jobApplication.getJobId());
	            appliedJob.setJobTitle(jobApplication.getTitle());
	            appliedJobs.add(appliedJob);
	        }
	    }
	    
	    return appliedJobs;
	}


	
	@Override
	public boolean updateJobsApplication(User user) {
		boolean status = false;
		try {
			userRepository.save(user);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean deleteJobApplication(Long jobId) {
		boolean status = false;
		try {
			jobRepository.deleteById(jobId);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> findAll = userRepository.findAll();
		return findAll;
	}



	@Override
	public User getUserById(Long userId) {
		Optional<User> optionalUser=userRepository.findById(userId);
		User user=new User();
		if(optionalUser.isPresent())
		{
			user=optionalUser.get();
		}
		return user;
	}

}
