package com.coforge.job.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.job.model.UserRegistration;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserRegistration, Integer>{
	
	public Optional<UserRegistration> findByUserNameAndPassword(String login, String password);
	
	public UserRegistration findByEmail(String email);

}
