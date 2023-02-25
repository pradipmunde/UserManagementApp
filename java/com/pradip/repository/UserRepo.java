package com.pradip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pradip.Model.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);
	
	User findByPassword(String password);

}
