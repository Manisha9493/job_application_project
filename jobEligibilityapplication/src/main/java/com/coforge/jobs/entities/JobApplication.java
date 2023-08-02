package com.coforge.jobs.entities;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
public class JobApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jobId;
	private String title;
	private String qualification;
	private String location;
	private int percentage;
	private int yearOfPassedOut;
	@JsonIgnore
	  @ManyToOne 
	  @JoinColumn(name = "user_id") private User user; 
	 
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
	public int getYearOfPassedOut() {
		return yearOfPassedOut;
	}
	public void setYearOfPassedOut(int yearOfPassedOut) {
		this.yearOfPassedOut = yearOfPassedOut;
	}
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "JobApplication [jobId=" + jobId + ", title=" + title + ", qualification=" + qualification
				+ ", location=" + location + ", percentage=" + percentage + ", yearOfPassedOut=" + yearOfPassedOut
				+ ", user=" + user + "]";
	}
	
	
	
	
	

}
