package com.coforge.jobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.jobs.entities.JobApplication;

@Repository
public interface JobRepository extends JpaRepository<JobApplication, Long>{

}
