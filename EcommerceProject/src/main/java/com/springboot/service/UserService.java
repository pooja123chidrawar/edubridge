package com.springboot.service;

import java.util.List;

import com.springboot.model.User;

public interface UserService {
	public User saveUser(User user);
	public List<User> getAllUsers();
	public User getUserById(long userId);
	public void deleteUserById(long userId);
	public User updateUser(User user,long userId);
	public User findByUserName(String userName);
	public User login(User user);
}
