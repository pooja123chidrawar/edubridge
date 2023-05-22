package com.springboot.controller;

import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.User;
import com.springboot.service.UserService;
import com.springboot.serviceImpl.UserServiceImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserController 
{
	@Autowired
	private UserService userService;

	public UserController(UserService userService) 
	{
		super();
		this.userService = userService;
	}
	//registration
	@PostMapping("api/register")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user)
	{
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);	
	}
	//Login
//	@PostMapping("/login")
//	public ResponseEntity<User> findByUserNameAndPassword(@PathVariable("userName")String userName,@PathVariable("password")String password){
//		return new ResponseEntity<User>(userService.findByUserNameAndPassword(userName, password),HttpStatus.OK);
//		
//	}
	@PostMapping("api/login")
	public ResponseEntity<User> login(@RequestBody User user){
		return new ResponseEntity<User>(userService.login(user),HttpStatus.OK);
		
	}
	@GetMapping("api/users")
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
	@GetMapping("api/users/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId")long userId)
	{
		return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
	}
	@DeleteMapping("api/users/delete/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable("userId")long userId){
		userService.deleteUserById(userId);
		return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
	}
	@PutMapping("api/users/update/{userId}")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user,@PathVariable("userId")long userId){
		return new ResponseEntity<User>(userService.updateUser(user, userId),HttpStatus.OK);
	}
	@GetMapping("api/users/byName/{userName}")
	public ResponseEntity<User> getUserByName(@PathVariable("userName")String userName){
		return new ResponseEntity<User>(userService.findByUserName(userName),HttpStatus.OK);
		
	}
}
