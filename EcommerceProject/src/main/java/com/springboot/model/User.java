package com.springboot.model;


import javax.persistence.Column;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="User_table")
public class User {
	@Id
	@SequenceGenerator(name="seq_user",sequenceName="user_sequence",initialValue=1000,allocationSize=100)
	@GeneratedValue(generator="seq_user")
	@Column(name="userId")
	private long userId;
	
	@NotEmpty
	@Column(name="userName")
	private String userName;
	
	@NotEmpty
	@Size(min=4,message="minimum 4 characters required")
	@Column(name="userLastname")
	private String userLastName;
	
	
	@Email(message="invalid email address")
	@Column(name="userEmail")
	private String userEmail;
	
	@Size(min=3,max=20,message="password contains between 3 to 20 chars")
	@Column(name="userPassword")
	private String password;
	
	
	@NotEmpty
	@Column(name="userPhoneNumber")
	private String PhoneNumber;
	
	@NotEmpty
	@Column(name="userAddress")
	private String address;
	
	@NotEmpty
	@Column(name="role")
	private String role;
	
	
	//Getters and Setters--
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public long getUserId() {
		return userId;
	}
	public User() {
		super();
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public User(long userId, @NotEmpty String userName,
			@NotEmpty @Size(min = 4, message = "minimum 4 characters required") String userLastName,
			@Email(message = "invalid email address") String userEmail,
			@Size(min = 3, max = 20, message = "password contains between 3 to 20 chars") String password,
			@NotEmpty String phoneNumber, @NotEmpty String address, @NotEmpty String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.password = password;
		PhoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userLastName=" + userLastName + ", userEmail="
				+ userEmail + ", password=" + password + ", PhoneNumber=" + PhoneNumber + ", address=" + address
				+ ", role=" + role + "]";
	}
	

}

