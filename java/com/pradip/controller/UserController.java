package com.pradip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pradip.Model.User;
import com.pradip.constants.AppConstants;
import com.pradip.dto.UserDto;
import com.pradip.service.UserServiceI;

@RestController
public class UserController {
	@Autowired
	UserServiceI userServiceI;
	
	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<User> loginUser(@PathVariable String email, String password){
		User login = this.userServiceI.login(email, password);
		return new ResponseEntity<User>(login, HttpStatus.OK);
		
	}
  
	@PostMapping(value="/createUser", consumes="application/json")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

		UserDto createUser = this.userServiceI.createUser(userDto);

		return new ResponseEntity(AppConstants.USER_CREATED, HttpStatus.CREATED);

	}

	@GetMapping(value="/getById/{userId}", produces="application/json")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId) {

		UserDto userById = this.userServiceI.getUserById(userId);

		return new ResponseEntity<UserDto>(userById, HttpStatus.OK);

	}

	@GetMapping(value="/getAll",produces="application/json")
	public ResponseEntity<List<UserDto>> getAllUser() {

		List<UserDto> allUser = this.userServiceI.getAllUser();
		return new ResponseEntity<List<UserDto>>(allUser, HttpStatus.OK);
	}

	public ResponseEntity<UserDto> deleteUser(@PathVariable Integer userId) {

		this.userServiceI.deleteUser(userId);
		return new ResponseEntity(AppConstants.USER_DELETED, HttpStatus.OK);

	}

}
