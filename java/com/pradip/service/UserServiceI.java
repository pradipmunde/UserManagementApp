package com.pradip.service;

import java.util.List;

import com.pradip.Model.User;
import com.pradip.dto.UserDto;

public interface UserServiceI {
	
	public UserDto createUser(UserDto userDto);
	
	public UserDto getUserById(Integer userId);
	
	public List<UserDto> getAllUser();
	
	public UserDto updateUser(UserDto userDto, Integer userId);
	
	public void deleteUser(Integer userId);
	
	public User login(String email, String password);
	
	

}
