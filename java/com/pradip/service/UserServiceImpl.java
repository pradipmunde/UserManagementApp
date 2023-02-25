package com.pradip.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pradip.Model.User;
import com.pradip.dto.UserDto;
import com.pradip.exception.ResourceNotFoundException;
import com.pradip.repository.UserRepo;

@Service
public class UserServiceImpl implements UserServiceI{
    @Autowired
	UserRepo userRepo;
    
    @Autowired
    ModelMapper modelMapper;
    
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		User save = this.userRepo.save(user);
		
		return this.modelMapper.map(save, UserDto.class);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("userId is not found"));
		
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> alluser = this.userRepo.findAll();
		List<UserDto> userDtos = alluser.stream().map((user) -> this.modelMapper.map(user, UserDto.class))
		.collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		this.userRepo.deleteById(userId);
		
	}

	@Override
	public User login(String email, String password) {
		User user = this.userRepo.findByEmail(email);
		User user2 = this.userRepo.findByPassword(password);
		
		if(user==user2) {
			return user;
		}return null;
		
//		List<User> list=new ArrayList();
//		list.add(user);
//		list.add(user2);
//		List<User> collect = list.stream().collect(Collectors.toList());
	     
	    
		
	}

}
