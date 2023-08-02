package com.coforge.jobs.service;

import java.util.List;

import com.coforge.jobs.binding.AppliedJobs;
import com.coforge.jobs.entities.User;

public interface JobApplicationService {
	
	public List<User> getAllUsers();
	public User saveJobApplication(User User);
	public boolean updateJobsApplication(User user);
	public boolean deleteJobApplication(Long jobId);
	public List<AppliedJobs> getAppliedJobs(Long userId);
	public User getUserById(Long userId);
	

}
