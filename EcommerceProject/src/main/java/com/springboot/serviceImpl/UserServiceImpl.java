package com.springboot.serviceImpl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.User;

import com.springboot.service.UserService;
import com.springboot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long userId) {
		return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
	}

	@Override
	public void deleteUserById(long userId) {
		userRepository.findById(userId);
		userRepository.deleteById(userId);
	}

	@Override
	public User updateUser(User user, long userId) {
		User user1=userRepository.findById(userId).get();
		user1.setUserName(user.getUserName());
		user1.setUserLastName(user.getUserLastName());
		user1.setUserEmail(user.getUserEmail());
		user1.setPassword(user.getPassword());
		user1.setPhoneNumber(user.getPhoneNumber());
		user1.setAddress(user.getAddress());
		user1.setRole(user.getRole());
		return userRepository.save(user1);
	}

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public User login(User user) {
		return userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		
	}
	



	

}
